/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.recyclerviews.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.travistorres.bakery.R;

/**
 * RecipeStepListItemViewHolder
 *
 * Provides an interface for specifying the contents of a Steps tabs user interface.
 *
 * @author Travis Anthony Torres
 * @version August 12, 2017
 */

public class RecipeStepListItemViewHolder extends RecyclerView.ViewHolder {
    private TextView stepNumberTextView;
    private TextView stepDescriptionTextView;

    /**
     * Retrieves all interface objects so that they can be pragmatically manipulated.
     *
     * @param itemView
     */
    public RecipeStepListItemViewHolder(View itemView) {
        super(itemView);

        stepNumberTextView = (TextView) itemView.findViewById(R.id.recipe_step_number);
        stepDescriptionTextView = (TextView) itemView.findViewById(R.id.recipe_step_description);
    }

    /**
     * Acquires a reference to the step counter.
     *
     * @return Specifies the step number in the Recipe sequence
     */
    public TextView getStepNumberTextView() {
        return stepNumberTextView;
    }

    /**
     * Acquires the field responsible for displaying the description of the step.
     *
     * @return Specifies the description for the step
     */
    public TextView getStepDescriptionTextView() {
        return stepDescriptionTextView;
    }
}
