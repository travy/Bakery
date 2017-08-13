/**
 * Copyright (c) Travis Anthony Torres
 */

package com.travistorres.bakery.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.travistorres.bakery.R;
import com.travistorres.bakery.interfaces.OnRecipeListItemClickedListener;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.networking.RecipeLoader;
import com.travistorres.bakery.recyclerviews.adapters.RecipeListAdapter;
import com.travistorres.bakery.recyclerviews.loaders.RecipeLoaderCallback;

import retrofit2.Callback;

/**
 * RecipeListActivity
 *
 * Displays a list of Recipes which is loaded in from an external RESTful server.
 *
 * @author Travis Anthony Torres
 * @version June 21, 2017
 */

public class RecipeListActivity extends AppCompatActivity
        implements OnRecipeListItemClickedListener {
    private RecipeListAdapter recipesListAdapter;
    private RecyclerView mRecipesRv;
    private String recipesApiUrl;

    /**
     * Displays the Recipe View Activity when a Recipe item is clicked.
     *
     * @param recipe
     */
    @Override
    public void onClick(Recipe recipe) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(getString(R.string.extra_key_for_recipe), recipe);

        startActivity(intent);
    }

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

        recipesApiUrl = getString(R.string.recipes_api_url);
        recipesListAdapter = new RecipeListAdapter(this);

        Resources res = getResources();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                res.getBoolean(R.bool.should_reverse_layout_for_recipes_list_layout_manager));

        mRecipesRv = (RecyclerView) findViewById(R.id.recipes_list_rv);
        mRecipesRv.setLayoutManager(layoutManager);
        mRecipesRv.setAdapter(recipesListAdapter);

        loadRecipes();
    }

    /**
     * Requests Recipes from the server and passes them to the RecyclerView.
     *
     */
    public void loadRecipes() {
        Callback recipesLoaderCallback = new RecipeLoaderCallback(this, recipesListAdapter);
        RecipeLoader recipeLoader = new RecipeLoader();
        recipeLoader.loadWithGsonConverter(recipesApiUrl, recipesLoaderCallback);
    }
}
