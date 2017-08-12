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
    private TextView measurementTypeTextView;
    private TextView measurementQuantityTextView;
    private TextView ingredientNameTextView;

    /**
     * Maps each of the user interface elements to an object so that they can be modified.
     *
     * @param itemView
     */
    public RecipeIngredientViewHolder(View itemView) {
        super(itemView);

        measurementTypeTextView = (TextView) itemView.findViewById(R.id.ingredient_measurement_type);
        measurementQuantityTextView = (TextView) itemView.findViewById(R.id.ingredient_measurement_qty);
        ingredientNameTextView = (TextView) itemView.findViewById(R.id.ingredient);
    }

    /**
     * Retrieves the interface object which displays the unit of measurement for the ingredient
     *
     * @return unit of measurement interface object
     */
    public TextView getMeasurementTypeTextView() {
        return measurementTypeTextView;
    }

    /**
     * Retrieves the interface object responsible for displaying the quantity of the ingredient
     * that are needed.
     *
     * @return quantity for the recipe
     */
    public TextView getMeasurementQuantityTextView() {
        return measurementQuantityTextView;
    }

    /**
     * Retrieves the interface object responsible for displaying the name of the ingredeint.
     *
     * @return name of the ingredient
     */
    public TextView getIngredientNameTextView() {
        return ingredientNameTextView;
    }
}
