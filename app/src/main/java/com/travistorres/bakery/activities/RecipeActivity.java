package com.travistorres.bakery.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.travistorres.bakery.R;
import com.travistorres.bakery.fragments.RecipeStepsItemFragment;
import com.travistorres.bakery.fragments.RecipeStepsListFragment;
import com.travistorres.bakery.interfaces.RecipeMasterDetailFlowInterface;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.models.Step;
import com.travistorres.bakery.utils.RecipeStepsIterator;

//  TODO- document
public class RecipeActivity extends AppCompatActivity
        implements RecipeMasterDetailFlowInterface {
    private Recipe recipe;
    private RecipeStepsListFragment stepsListFragment;
    private RecipeStepsItemFragment stepDetailFragment;
    private RecipeStepsIterator stepIterator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        recipe = intent.getParcelableExtra(getString(R.string.extra_key_for_recipe));

        stepIterator = new RecipeStepsIterator(recipe.getSteps());

        FragmentManager fragmentManager = getSupportFragmentManager();
        stepsListFragment = (RecipeStepsListFragment) fragmentManager
                .findFragmentById(R.id.fragment_recipe_steps_list);
        stepDetailFragment = (RecipeStepsItemFragment) fragmentManager
                .findFragmentById(R.id.fragment_recipe_step_item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Step currentStep = stepIterator.getCurrent();
        stepDetailFragment.setStep(currentStep);
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public void onSelectedStep(Step step) {
        if (step != stepIterator.getCurrent()) {
            stepIterator.setCurrent(step);
        }

        stepDetailFragment.setStep(step);
    }

    @Override
    public void onSelectNextStep() {
        if (stepIterator.hasNext()) {
            Step next = stepIterator.next();
            stepDetailFragment.setStep(next);
        }
    }

    @Override
    public void onSelectPreviousStep() {
        if (stepIterator.hasPrevious()) {
            Step previous = stepIterator.previous();
            stepDetailFragment.setStep(previous);
        }
    }

    @Override
    public boolean hasNextStep() {
        return stepIterator.hasNext();
    }

    @Override
    public boolean hasPreviousStep() {
        return stepIterator.hasPrevious();
    }
}
