/**
 * Copyright (c) Travis Anthony Torres
 */

package com.travistorres.bakery.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.travistorres.bakery.R;
import com.travistorres.bakery.interfaces.OnRecipeListItemClickedListener;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.networking.RecipeLoader;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * RecipeListActivity
 *
 * Displays a list of Recipes which is loaded in from an external RESTful server.
 *
 * @author Travis Anthony Torres
 * @version June 21, 2017
 */

//  TODO:  separate all Recycler View helper classes into their own files

public class RecipeListActivity extends AppCompatActivity
        implements OnRecipeListItemClickedListener {
    private RecyclerView mRecipesRv;
    private RecipesAdapter recipesListAdapter;

    private String recipesApiUrl;

    @Override
    public void onClick(Recipe recipe) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(getString(R.string.extra_key_for_recipe), recipe);

        startActivity(intent);
    }

    private class RecipeListViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public ImageView thumbnailImageView;
        public TextView ingredientsCountTextView;
        public TextView servingsCountTextView;
        public TextView titleTextView;

        private RecipesAdapter adapter;
        private OnRecipeListItemClickedListener clickHandler;

        public RecipeListViewHolder(View itemView, RecipesAdapter recipeAdapter, OnRecipeListItemClickedListener recipeClickHandler) {
            super(itemView);

            thumbnailImageView = (ImageView) itemView.findViewById(R.id.recipe_thumbnail);
            ingredientsCountTextView = (TextView) itemView.findViewById(R.id.ingredients_count);
            servingsCountTextView = (TextView) itemView.findViewById(R.id.servings_count);
            titleTextView = (TextView) itemView.findViewById(R.id.recipe_name);

            adapter = recipeAdapter;
            clickHandler = recipeClickHandler;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Recipe recipe = adapter.getRecipeAt(pos);

            clickHandler.onClick(recipe);
        }
    }

    private class RecipesAdapter extends RecyclerView.Adapter {
        private List<Recipe> recipesList;
        private OnRecipeListItemClickedListener clickHandler;


        public RecipesAdapter(OnRecipeListItemClickedListener recipeClickHandler) {
            clickHandler = recipeClickHandler;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            Resources res = getResources();
            View view = inflater.inflate(
                    R.layout.recipe_list_item,
                    parent,
                    res.getBoolean(R.bool.should_attatch_to_root_while_inflating_recipe_item));

            return new RecipeListViewHolder(view, this, clickHandler);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Recipe recipe = recipesList.get(position);

            RecipeListViewHolder recipeView = (RecipeListViewHolder) holder;

            //  TODO:  replace recipe.getIngredients().length with recipe.numberOfIngredients()
            recipeView.ingredientsCountTextView.setText(Integer.toString(recipe.getIngredients().length));
            recipeView.servingsCountTextView.setText(Integer.toString(recipe.numberOfSteps()));
            recipeView.titleTextView.setText(recipe.getName());
        }

        @Override
        public int getItemCount() {
            return recipesList == null ? 0 : recipesList.size();
        }

        public Recipe getRecipeAt(int position) {
            return recipesList.get(position);
        }

        public boolean setRecipeList(List<Recipe> list) {
            recipesList = list;

            notifyDataSetChanged();

            return true;
        }
    }

    private class RecipesLoaderCallbacks implements Callback<List<Recipe>> {
        @Override
        public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
            List<Recipe> recipes = response.body();

            recipesListAdapter.setRecipeList(recipes);
        }

        @Override
        public void onFailure(Call<List<Recipe>> call, Throwable t) {
            Toast.makeText(
                    RecipeListActivity.this,
                    getString(R.string.error_could_not_load_movies),
                    Toast.LENGTH_SHORT).show();
        }
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
        recipesListAdapter = new RecipesAdapter(this);

        Resources res = getResources();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                res.getBoolean(R.bool.should_reverse_layout_for_recipes_list_layout_manager));

        mRecipesRv = (RecyclerView) findViewById(R.id.recipes_list_rv);
        mRecipesRv.setLayoutManager(layoutManager);
        mRecipesRv.setAdapter(recipesListAdapter);

        loadMovies();
    }

    public void loadMovies() {
        Callback recipesLoaderCallback = new RecipesLoaderCallbacks();
        RecipeLoader recipeLoader = new RecipeLoader();
        recipeLoader.loadWithGsonConverter(recipesApiUrl, recipesLoaderCallback);
    }
}
