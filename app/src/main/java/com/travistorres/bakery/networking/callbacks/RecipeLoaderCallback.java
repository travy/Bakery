/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.networking.callbacks;

import android.content.Context;
import android.widget.Toast;

import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.R;
import com.travistorres.bakery.recyclerviews.adapters.RecipeListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * RecipeLoaderCallback
 *
 * Describes what should be done after a network operation is formed which acquires a list of
 * Recipes from a server.
 *
 * @author Travis Anthony Torres
 * @version August 13, 2017
 */

public class RecipeLoaderCallback implements Callback<List<Recipe>> {
    private Context context;
    private RecipeListAdapter adapter;

    /**
     * Provides a context and adapter for use on operations.
     *
     * @param applicationContext
     * @param recipeAdapter
     */
    public RecipeLoaderCallback(Context applicationContext, RecipeListAdapter recipeAdapter) {
        adapter = recipeAdapter;
        context = applicationContext;
    }

    /**
     * Maps the information acquired from a network requests into an Adapter where it will be
     * displayed.
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
        List<Recipe> recipes = response.body();
        adapter.setRecipeList(recipes);
    }

    /**
     * Displays a message which reads that the network operation has failed.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<List<Recipe>> call, Throwable t) {
        Toast.makeText(
                context,
                R.string.error_could_not_load_movies,
                Toast.LENGTH_SHORT).show();
    }
}
