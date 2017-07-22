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
}
