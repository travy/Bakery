/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.recyclerviews.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.travistorres.bakery.R;
import com.travistorres.bakery.interfaces.OnRecipeListItemClickedListener;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.recyclerviews.adapters.RecipeListAdapter;

/**
 * RecipeListItemViewHolder
 *
 * Responsible for providing an interface to a View that displays information about a Recipe.
 *
 * @author Travis Anthony Torres
 * @version August 13, 2017
 */

public class RecipeListItemViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
    private ImageView thumbnailImageView;
    private OnRecipeListItemClickedListener clickHandler;
    private RecipeListAdapter adapter;
    private TextView ingredientsCountTextView;
    private TextView servingsCountTextView;
    private TextView titleTextView;

    /**
     * Maps the elements of the Layout file onto the object so that they can be manipulated
     * pragmatically.
     *
     * @param itemView
     * @param recipeAdapter
     * @param recipeClickHandler
     */
    public RecipeListItemViewHolder(View itemView, RecipeListAdapter recipeAdapter,
                                    OnRecipeListItemClickedListener recipeClickHandler) {
        super(itemView);

        adapter = recipeAdapter;
        clickHandler = recipeClickHandler;
        ingredientsCountTextView = (TextView) itemView.findViewById(R.id.ingredients_count);
        servingsCountTextView = (TextView) itemView.findViewById(R.id.servings_count);
        thumbnailImageView = (ImageView) itemView.findViewById(R.id.recipe_thumbnail);
        titleTextView = (TextView) itemView.findViewById(R.id.recipe_name);

        itemView.setOnClickListener(this);
    }

    /**
     * Specifies what should occur when a Recipe is clicked.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        int pos = getAdapterPosition();
        Recipe recipe = adapter.getRecipeAt(pos);
        clickHandler.onClick(recipe);
    }

    /**
     * View which displays a thumbnail for the Recipe.
     *
     * @return Thumbnail view
     */
    public ImageView getThumbnailImageView() {
        return thumbnailImageView;
    }

    /**
     * View which shows the number of ingredients.
     *
     * @return Ingredients count
     */
    public TextView getIngredientsCountTextView() {
        return ingredientsCountTextView;
    }

    /**
     * View which displays the number of servings.
     *
     * @return Servings size
     */
    public TextView getServingsCountTextView() {
        return servingsCountTextView;
    }

    /**
     * Retrieves a View object that displays the name of the Recipe.
     *
     * @return Name of recipe
     */
    public TextView getTitleTextView() {
        return titleTextView;
    }
}
