/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.recyclerviews.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.travistorres.bakery.R;
import com.travistorres.bakery.interfaces.RecipeMasterDetailFlowInterface;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.models.Step;

/**
 * RecipeStepListItemViewHolder
 *
 * Provides an interface for specifying the contents of a Steps tabs user interface.
 *
 * @author Travis Anthony Torres
 * @version August 12, 2017
 */

public class RecipeStepListItemViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
    private RecipeMasterDetailFlowInterface masterDetailFlowInterface;
    private TextView stepDescriptionTextView;
    private TextView stepNumberTextView;

    /**
     * Retrieves all interface objects so that they can be pragmatically manipulated.
     *
     * @param itemView
     * @param clickableOperation
     */
    public RecipeStepListItemViewHolder(View itemView, RecipeMasterDetailFlowInterface clickableOperation) {
        super(itemView);

        masterDetailFlowInterface = clickableOperation;
        stepDescriptionTextView = (TextView) itemView.findViewById(R.id.recipe_step_description);
        stepNumberTextView = (TextView) itemView.findViewById(R.id.recipe_step_number);

        itemView.setOnClickListener(this);
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

    /**
     * Performs the desired operation for when a Step has been selected.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        int stepItem = getAdapterPosition();
        Recipe recipe = masterDetailFlowInterface.getRecipe();
        Step[] steps = recipe.getSteps();
        Step selectedStep = steps[stepItem];

        masterDetailFlowInterface.onSelectedStep(selectedStep);
    }
}
