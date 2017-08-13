/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.recyclerviews.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travistorres.bakery.R;
import com.travistorres.bakery.models.Ingredient;
import com.travistorres.bakery.recyclerviews.viewholders.RecipeIngredientViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * RecipeIngredientAdapter
 *
 * Responsible for delegating how a set of Ingredient objects will be mapped onto the user
 * interface while controlling efficiency of the device.
 *
 * @author Travis Anthony Torres
 * @version August 12, 2017
 */

public class RecipeIngredientAdapter extends RecyclerView.Adapter {
    private List<Ingredient> ingredientList;

    /**
     * Inflates the user interface view resource responsible for representing an ingredient onto
     * a programmable View.
     *
     * @param parent
     * @param viewType
     *
     * @return ViewHolder responsible for displaying the user interface for an ingredient
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(
                R.layout.recipe_ingredient,
                parent,
                false);

        return new RecipeIngredientViewHolder(view);
    }

    /**
     * Maps all of the information for an individual ingredient item onto a provided ViewHolder.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Ingredient ingredient = ingredientList.get(position);
        String name = ingredient.getIngredient();
        String unitOfMeasure = ingredient.getUnitsOfMeasurement();

        RecipeIngredientViewHolder view = (RecipeIngredientViewHolder) holder;
        view.getIngredientNameTextView().setText(name);
        view.getUnitsOfMeasureTextView().setText(unitOfMeasure);
    }

    /**
     * Obtains the number of items displayed within the interface.
     *
     * @return number of ingredients
     */
    @Override
    public int getItemCount() {
        return ingredientList == null ? 0 : ingredientList.size();
    }

    /**
     * Resets the list of ingredients with new information.
     *
     * @param ingredients
     *
     * @return List containing all ingredients
     */
    public List<Ingredient> setIngredients(Ingredient[] ingredients) {
        ingredientList = new ArrayList<Ingredient>();
        for(Ingredient ingredient : ingredients) {
            ingredientList.add(ingredient);
        }

        notifyDataSetChanged();

        return ingredientList;
    }
}
