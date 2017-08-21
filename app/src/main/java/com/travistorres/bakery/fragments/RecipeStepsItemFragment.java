package com.travistorres.bakery.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.travistorres.bakery.R;
import com.travistorres.bakery.models.Step;

public class RecipeStepsItemFragment extends Fragment {
    private Button nextStepButton;
    private Button previousStepButton;
    private TextView descriptionTextView;
    private TextView shortDescriptionTextView;

    private Step step;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe_step_instruction_list_item, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        nextStepButton = (Button) view.findViewById(R.id.next_step_button);
        previousStepButton = (Button) view.findViewById(R.id.previous_step_button);
        descriptionTextView = (TextView) view.findViewById(R.id.step_description);
        shortDescriptionTextView = (TextView) view.findViewById(R.id.step_short_description);

        setStep(null);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setStep(@Nullable Step newStep) {
        step = newStep;

        updateStepInformation();
    }

    private void updateStepInformation() {
        boolean isStepSpecified = step != null;
        int viewVisibility = isStepSpecified ?
                View.VISIBLE :
                View.INVISIBLE;

        nextStepButton.setVisibility(viewVisibility);
        previousStepButton.setVisibility(viewVisibility);
        descriptionTextView.setVisibility(viewVisibility);
        shortDescriptionTextView.setVisibility(viewVisibility);

        if (isStepSpecified) {
            descriptionTextView.setText(step.getDescription());
            shortDescriptionTextView.setText(step.getShortDescription());
        }
    }
}
