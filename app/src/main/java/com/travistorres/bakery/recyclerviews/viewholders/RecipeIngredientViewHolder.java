/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.recyclerviews.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.travistorres.bakery.R;

/**
 * RecipeIngredientViewHolder
 *
 * Provides an interface for mapping data onto a view which displays an ingredient belonging to a
 * Recipe.
 *
 * @author Travis Anthony Torres
 * @version August 12, 2017
 */

public class RecipeIngredientViewHolder extends RecyclerView.ViewHolder {
    private TextView ingredientNameTextView;
    private TextView unitsOfMeasureTextView;

    /**
     * Maps each of the user interface elements to an object so that they can be modified.
     *
     * @param itemView
     */
    public RecipeIngredientViewHolder(View itemView) {
        super(itemView);

        ingredientNameTextView = (TextView) itemView.findViewById(R.id.ingredient);
        unitsOfMeasureTextView = (TextView) itemView.findViewById(R.id.units_of_measure);
    }

    /**
     * Retrieves the interface object responsible for displaying the name of the ingredient.
     *
     * @return Name of the ingredient
     */
    public TextView getIngredientNameTextView() {
        return ingredientNameTextView;
    }

    /**
     * Retrieves the interface object responsible for displaying the units of measurement.
     *
     * @return Unit of measurement
     */
    public TextView getUnitsOfMeasureTextView() {
        return unitsOfMeasureTextView;
    }
}
