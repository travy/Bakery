/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.travistorres.bakery.fragments.RecipeStepsItemFragment;
import com.travistorres.bakery.fragments.RecipeStepsListFragment;
import com.travistorres.bakery.interfaces.RecipeMasterDetailFlowInterface;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.models.Step;
import com.travistorres.bakery.R;
import com.travistorres.bakery.utils.RecipeStepsIterator;

/**
 * RecipeActivity
 *
 * The RecipeActivity will allow users to navigate between the sequence of steps required in
 * preparing the Dish.  Users will be presented with a list of all ingredients needed as well as
 * detail and videos for each step in the Recipe.
 *
 * @author Travis Anthony Torres
 * @version August 20, 2017
 */

public class RecipeActivity extends AppCompatActivity
        implements RecipeMasterDetailFlowInterface {
    private Recipe recipe;
    private RecipeStepsItemFragment stepDetailFragment;
    private RecipeStepsIterator stepIterator;
    private RecipeStepsListFragment stepsListFragment;

    /**
     * Preserves the state of the user interface as the Activity is destroyed and rebuilt.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        //  retrieves the selected recipe from the previous activity
        Intent intent = getIntent();
        recipe = intent.getParcelableExtra(getString(R.string.extra_key_for_recipe));

        //  tracks the selected step
        stepIterator = new RecipeStepsIterator(recipe.getSteps());

        //  acquires the Fragments for displaying the master detail view
        FragmentManager fragmentManager = getSupportFragmentManager();
        stepsListFragment = (RecipeStepsListFragment) fragmentManager
                .findFragmentById(R.id.fragment_recipe_steps_list);
        stepDetailFragment = (RecipeStepsItemFragment) fragmentManager
                .findFragmentById(R.id.fragment_recipe_step_item);
    }

    /**
     * Specifies the Step that should be displayed within the Detail view.
     *
     */
    @Override
    protected void onResume() {
        super.onResume();

        Step currentStep = stepIterator.getCurrent();
        stepDetailFragment.setStep(currentStep);
    }

    /**
     * Retrieves the recipe that was selected by the user.
     *
     * @return
     */
    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Supplies the Step that the user selected from the Step list, as the information that should
     * be displayed in the detail view.
     *
     * @param step
     */
    @Override
    public void onSelectedStep(Step step) {
        if (step != stepIterator.getCurrent()) {
            stepIterator.setCurrent(step);
        }

        stepDetailFragment.setStep(step);
    }

    /**
     * Iterates through the list of Steps to which ever one comes next when preparing the Recipe.
     *
     */
    @Override
    public void onSelectNextStep() {
        if (stepIterator.hasNext()) {
            Step next = stepIterator.next();
            stepDetailFragment.setStep(next);
        }
    }

    /**
     * Iterates through the list of Steps and determines the last one that was performed and
     * displays it within the detail view.
     *
     */
    @Override
    public void onSelectPreviousStep() {
        if (stepIterator.hasPrevious()) {
            Step previous = stepIterator.previous();
            stepDetailFragment.setStep(previous);
        }
    }

    /**
     * Determines if there is another Step after the one which is currently selected.
     *
     * @return whether there is another step
     */
    @Override
    public boolean hasNextStep() {
        return stepIterator.hasNext();
    }

    /**
     * Determines if there was a Step prior to the one which is currently selected.
     *
     * @return whether there was a previous step
     */
    @Override
    public boolean hasPreviousStep() {
        return stepIterator.hasPrevious();
    }
}
