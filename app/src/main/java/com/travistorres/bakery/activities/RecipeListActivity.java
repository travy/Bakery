/**
 * Copyright (c) Travis Anthony Torres
 */

package com.travistorres.bakery.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.travistorres.bakery.R;
import com.travistorres.bakery.models.Recipe;

import java.util.List;

/**
 * RecipeListActivity
 *
 * Displays a list of Recipes which is loaded in from an external RESTful server.
 *
 * @author Travis Anthony Torres
 * @version June 21, 2017
 */

public class RecipeListActivity extends AppCompatActivity {
    private List<Recipe> recipes;

    /**
     * Loads in all pertinent information for use in the list.  Also setsup the user interface so
     * that they can be managed properly by the Activity.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
    }

    /**
     * Sets a List of Recipes to display.
     *
     * @param recipes
     *
     * @return true if a List of Recipes was successfully saved and false otherwise.
     */
    public boolean setRecipes(List<Recipe> recipes) {
        return false;
    }

    /**
     * Retrieves a copy List of Recipes loaded.
     *
     * @return List of Recipe objects or null if none have been defined.
     */
    public List<Recipe> getRecipes() {
        return null;
    }

    /**
     * Retrieves a count of all recipes.
     *
     * @return Number of Recipes that has been loaded.
     */
    public long getNumberOfRecipes() {
        return 0;
    }
}
