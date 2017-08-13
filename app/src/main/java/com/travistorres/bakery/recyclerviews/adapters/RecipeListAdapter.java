/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.recyclerviews.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travistorres.bakery.R;
import com.travistorres.bakery.interfaces.OnRecipeListItemClickedListener;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.recyclerviews.viewholders.RecipeListItemViewHolder;

import java.util.List;

/**
 * RecipeListAdapter
 *
 * Maps information about a set of Recipes onto a user interface.
 *
 * @author Travis Anthony Torres
 * @version August 13, 2017
 */

public class RecipeListAdapter extends RecyclerView.Adapter {
    private List<Recipe> recipesList;
    private OnRecipeListItemClickedListener clickHandler;

    /**
     * Provides a click handler that instructs what to do when a recipe is clicked.
     *
     * @param recipeClickHandler
     */
    public RecipeListAdapter(OnRecipeListItemClickedListener recipeClickHandler) {
        clickHandler = recipeClickHandler;
    }

    /**
     * Inflates a interface layout file onto a View so that data can be embedded onto it.
     *
     * @param parent
     * @param viewType
     *
     * @return ViewHolder responsible for displaying information regarding the Recipe
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        Resources res = context.getResources();
        View view = inflater.inflate(
                R.layout.recipe_list_item,
                parent,
                res.getBoolean(R.bool.should_attatch_to_root_while_inflating_recipe_item));

        return new RecipeListItemViewHolder(view, this, clickHandler);
    }

    /**
     * Maps the data from the Recipe onto the List view.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Recipe recipe = recipesList.get(position);
        String numberOfIngredients = Integer.toString(recipe.getNumberOfIngredients());
        String numberOfServings = Double.toString(recipe.getServings());
        String recipeName = recipe.getName();

        RecipeListItemViewHolder recipeView = (RecipeListItemViewHolder) holder;
        recipeView.getIngredientsCountTextView().setText(numberOfIngredients);
        recipeView.getServingsCountTextView().setText(numberOfServings);
        recipeView.getTitleTextView().setText(recipeName);
    }

    /**
     * Retrieves a count of all items within the list.
     *
     * @return count of all items
     */
    @Override
    public int getItemCount() {
        return recipesList == null ? 0 : recipesList.size();
    }

    /**
     * Retrieves a Recipe at a given position.
     *
     * @param position
     *
     * @return The Recipe at the specified position
     */
    public Recipe getRecipeAt(int position) {
        return recipesList.get(position);
    }

    /**
     * Specifies a list of Recipes that should be displayed.
     *
     * @param list
     *
     * @return List of Recipes which have been rendered
     */
    public List<Recipe> setRecipeList(List<Recipe> list) {
        recipesList = list;

        notifyDataSetChanged();

        return recipesList;
    }
}
