/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.travistorres.bakery.models.Step;
import com.travistorres.bakery.R;

/**
 * RecipeStepItemFragment
 *
 * Provides an interface for displaying information on a specific Step when preparing a Recipe.
 *
 * @author Travis Anthony Torres
 * @version August 20, 2017
 */

public class RecipeStepsItemFragment extends RecipeMasterDetailFlowFragment
        implements View.OnClickListener {
    private Button nextStepButton;
    private Button previousStepButton;
    private TextView descriptionTextView;
    private TextView shortDescriptionTextView;

    private Step step;

    /**
     * Creates a View for displaying information on the specified Step.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     *
     * @return interface
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe_step_instruction_list_item, container, false);
    }

    /**
     * Specifies how to setup the user interface when the View is rendered by the base Activity.
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        nextStepButton = (Button) view.findViewById(R.id.next_step_button);
        previousStepButton = (Button) view.findViewById(R.id.previous_step_button);
        descriptionTextView = (TextView) view.findViewById(R.id.step_description);
        shortDescriptionTextView = (TextView) view.findViewById(R.id.step_short_description);

        nextStepButton.setOnClickListener(this);
        previousStepButton.setOnClickListener(this);

        setStep(null);
    }

    /**
     * Specifies the Step that should be displayed.
     *
     * @param newStep
     */
    public void setStep(@Nullable Step newStep) {
        step = newStep;

        updateStepInformation();
    }

    /**
     * Will display information about a selected Step if one has been specified.
     *
     */
    private void updateStepInformation() {
        boolean isStepSpecified = step != null;
        int viewVisibility = isStepSpecified ?
                View.VISIBLE :
                View.INVISIBLE;

        //  hides all of the view elements when there is no Step specified
        nextStepButton.setVisibility(viewVisibility);
        previousStepButton.setVisibility(viewVisibility);
        descriptionTextView.setVisibility(viewVisibility);
        shortDescriptionTextView.setVisibility(viewVisibility);

        //  displays information regarding stored within the step
        if (isStepSpecified) {
            descriptionTextView.setText(step.getDescription());
            shortDescriptionTextView.setText(step.getShortDescription());
            nextStepButton.setEnabled(masterDetailFlowInterface.hasNextStep());
            previousStepButton.setEnabled(masterDetailFlowInterface.hasPreviousStep());
        }
    }

    /**
     * Determines if the user has pressed the next or the previous Step button.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v == nextStepButton) {
            masterDetailFlowInterface.onSelectNextStep();
        } else {
            masterDetailFlowInterface.onSelectPreviousStep();
        }
    }
}
