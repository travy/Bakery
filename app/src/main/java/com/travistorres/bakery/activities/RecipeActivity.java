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

//  TODO- document
public class RecipeActivity extends AppCompatActivity
        implements RecipeMasterDetailFlowInterface {
    private Recipe recipe;
    private RecipeStepsListFragment stepsListFragment;
    private RecipeStepsItemFragment stepDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        recipe = intent.getParcelableExtra(getString(R.string.extra_key_for_recipe));

        FragmentManager fragmentManager = getSupportFragmentManager();

        stepsListFragment = new RecipeStepsListFragment();
        fragmentManager
                .beginTransaction()
                .add(R.id.recipe_steps_list_fragment, stepsListFragment)
                .commit();

        stepDetailFragment = (RecipeStepsItemFragment) fragmentManager
                        .findFragmentById(R.id.fragment_recipe_step_item);
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public void onSelectedStep(Step step) {
        stepDetailFragment.setStep(step);
    }

    @Override
    public void onSelectNextStep() {
        Toast.makeText(this, "Select Next Step", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSelectPreviousStep() {
        Toast.makeText(this, "Select previous step", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean hasNextStep() {
        return false;
    }

    @Override
    public boolean hasPreviousStep() {
        return false;
    }
}
