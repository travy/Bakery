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
import com.travistorres.bakery.models.Ingredient;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.recyclerviews.viewholders.RecipeIngredientViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {
    private Recipe recipe;

    private TextView recipeTitleTextView;
    private RecyclerView ingredientsRecyclerView;

    private class RecipeIngredientsAdapter extends RecyclerView.Adapter {
        private List<Ingredient> ingredientList;

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

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Ingredient ingredient = ingredientList.get(position);
            String ingredientName = ingredient.getIngredient();
            String quantity = Double.toString(ingredient.getQuantity());
            String unitOfMeasure = ingredient.getMeasure();

            RecipeIngredientViewHolder view = (RecipeIngredientViewHolder) holder;
            view.getIngredientNameTextView().setText(ingredientName);
            view.getMeasurementQuantityTextView().setText(quantity);
            view.getMeasurementTypeTextView().setText(unitOfMeasure);
        }

        public List<Ingredient> setIngredients(Ingredient[] ingredients) {
            ingredientList = new ArrayList<Ingredient>();
            for(Ingredient ingredient : ingredients) {
                ingredientList.add(ingredient);
            }

            notifyDataSetChanged();

            return ingredientList;
        }

        @Override
        public int getItemCount() {
            return ingredientList == null ? 0 : ingredientList.size();
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

        RecipeIngredientsAdapter adapter = new RecipeIngredientsAdapter();
        ingredientsRecyclerView = (RecyclerView) findViewById(R.id.recipe_ingredients_rv);
        ingredientsRecyclerView.setAdapter(adapter);
        ingredientsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter.setIngredients(recipe.getIngredients());
    }
}
