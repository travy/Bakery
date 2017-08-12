package com.travistorres.bakery.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.travistorres.bakery.R;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.recyclerviews.adapters.RecipeIngredientAdapter;
import com.travistorres.bakery.recyclerviews.adapters.RecipeStepAdapter;

public class RecipeActivity extends AppCompatActivity {
    private Recipe recipe;

    private TextView recipeTitleTextView;
    private RecyclerView ingredientsRecyclerView;
    private RecyclerView stepsRecyclerView;

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
