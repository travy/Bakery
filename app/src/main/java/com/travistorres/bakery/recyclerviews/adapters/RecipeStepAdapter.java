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
import com.travistorres.bakery.models.Step;
import com.travistorres.bakery.recyclerviews.viewholders.RecipeStepViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * RecipeStepAdapter
 *
 * Responsible for mapping data relating to the Steps for a Recipe into the user interface for
 * use.
 *
 * @author Travis Anthony Torres
 * @version August 12, 2017
 */

public class RecipeStepAdapter extends RecyclerView.Adapter {
    private List<Step> stepsList;

    /**
     * Inflates a layout file to be used for the presentation of steps in the RecyclerView.
     *
     * @param parent
     * @param viewType
     *
     * @return ViewHolder for the Step
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(
                R.layout.recipe_step,
                parent,
                false);

        return new RecipeStepViewHolder(view);
    }

    /**
     * Maps information regarding a step onto the user interface.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Step step = stepsList.get(position++);
        String stepNumber = Integer.toString(position);
        String description = step.getShortDescription();

        RecipeStepViewHolder view = (RecipeStepViewHolder) holder;
        view.getStepNumberTextView().setText(stepNumber);
        view.getStepDescriptionTextView().setText(description);
    }

    /**
     * Retrieves the number of steps in the adapter.
     *
     * @return number of steps
     */
    @Override
    public int getItemCount() {
        return stepsList == null ? 0 : stepsList.size();
    }

    /**
     * Resets the list of Steps.  The order in which Steps are inserted into the Array will
     * determine their sequence when presented to the user.
     *
     * @param steps
     *
     * @return List of all steps
     */
    public List<Step> setSteps(Step[] steps) {
        stepsList = new ArrayList<Step>();

        for(Step step : steps) {
            stepsList.add(step);
        }

        notifyDataSetChanged();

        return stepsList;
    }
}
