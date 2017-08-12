package com.travistorres.bakery.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.travistorres.bakery.R;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.models.Step;
import com.travistorres.bakery.recyclerviews.adapters.RecipeIngredientAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {
    private Recipe recipe;

    private TextView recipeTitleTextView;
    private RecyclerView ingredientsRecyclerView;
    private RecyclerView stepsRecyclerView;

    private class RecipeStepViewHolder extends RecyclerView.ViewHolder {
        private TextView stepNumberTextView;
        private TextView stepDescriptionTextView;

        public RecipeStepViewHolder(View itemView) {
            super(itemView);

            stepNumberTextView = (TextView) itemView.findViewById(R.id.recipe_step_number);
            stepDescriptionTextView = (TextView) itemView.findViewById(R.id.recipe_step_description);
        }

        public TextView getStepNumberTextView() {
            return stepNumberTextView;
        }

        public TextView getStepDescriptionTextView() {
            return stepDescriptionTextView;
        }
    }

    private class RecipeStepAdapter extends RecyclerView.Adapter {
        private List<Step> stepsList;

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

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Step step = stepsList.get(position++);
            String stepNumber = Integer.toString(position);
            String description = step.getShortDescription();

            RecipeStepViewHolder view = (RecipeStepViewHolder) holder;
            view.getStepNumberTextView().setText(stepNumber);
            view.getStepDescriptionTextView().setText(description);
        }

        @Override
        public int getItemCount() {
            return stepsList == null ? 0 : stepsList.size();
        }

        public List<Step> setSteps(Step[] steps) {
            stepsList = new ArrayList<Step>();

            for(Step step : steps) {
                stepsList.add(step);
            }

            notifyDataSetChanged();

            return stepsList;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        recipe = intent.getParcelableExtra(getString(R.string.extra_key_for_recipe));

        recipeTitleTextView = (TextView) findViewById(R.id.recipe_name);
        recipeTitleTextView.setText(recipe.getName());

        setupIngredientsRecyclerView();
        setupStepsRecyclerView();
    }

    private void setupIngredientsRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecipeIngredientAdapter adapter = new RecipeIngredientAdapter();

        ingredientsRecyclerView = (RecyclerView) findViewById(R.id.recipe_ingredients_rv);
        ingredientsRecyclerView.setLayoutManager(layoutManager);
        ingredientsRecyclerView.setAdapter(adapter);

        adapter.setIngredients(recipe.getIngredients());
    }

    private void setupStepsRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecipeStepAdapter adapter = new RecipeStepAdapter();

        stepsRecyclerView = (RecyclerView) findViewById(R.id.recipe_steps_rv);
        stepsRecyclerView.setLayoutManager(layoutManager);
        stepsRecyclerView.setAdapter(adapter);

        adapter.setSteps(recipe.getSteps());
    }
}
