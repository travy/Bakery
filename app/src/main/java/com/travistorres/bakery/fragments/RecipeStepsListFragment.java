package com.travistorres.bakery.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.travistorres.bakery.R;
import com.travistorres.bakery.interfaces.RecipeMasterDetailFlowInterface;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.recyclerviews.adapters.RecipeIngredientAdapter;
import com.travistorres.bakery.recyclerviews.adapters.RecipeStepAdapter;

//  TODO- document
public class RecipeStepsListFragment extends Fragment {
    private TextView recipeTitleTextView;
    private RecyclerView ingredientsRecyclerView;
    private RecyclerView stepsRecyclerView;
    private Recipe recipe;

    private RecipeMasterDetailFlowInterface masterDetailInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof RecipeMasterDetailFlowInterface) {
            masterDetailInterface = (RecipeMasterDetailFlowInterface) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement " + RecipeMasterDetailFlowInterface.class.getName());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        recipe = masterDetailInterface.getRecipe();

        View view = inflater.inflate(R.layout.fragment_recipe_steps_list, container, false);
        recipeTitleTextView = (TextView) view.findViewById(R.id.recipe_name);
        recipeTitleTextView.setText(recipe.getName());

        Context context = getContext();
        setupIngredientsRecyclerView(context, view);
        setupStepsRecyclerView(context, view);

        return view;
    }

    private void setupIngredientsRecyclerView(Context context, View view) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        RecipeIngredientAdapter adapter = new RecipeIngredientAdapter();

        ingredientsRecyclerView = (RecyclerView) view.findViewById(R.id.recipe_ingredients_rv);
        ingredientsRecyclerView.setLayoutManager(layoutManager);
        ingredientsRecyclerView.setAdapter(adapter);

        adapter.setIngredients(recipe.getIngredients());
    }

    private void setupStepsRecyclerView(Context context, View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        RecipeStepAdapter adapter = new RecipeStepAdapter(masterDetailInterface);

        stepsRecyclerView = (RecyclerView) view.findViewById(R.id.recipe_steps_rv);
        stepsRecyclerView.setLayoutManager(layoutManager);
        stepsRecyclerView.setAdapter(adapter);

        adapter.setSteps(recipe.getSteps());
    }
}
