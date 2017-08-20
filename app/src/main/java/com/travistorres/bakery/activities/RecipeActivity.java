package com.travistorres.bakery.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.travistorres.bakery.R;
import com.travistorres.bakery.fragments.RecipeStepsListFragment;
import com.travistorres.bakery.interfaces.RecipeMasterDetailFlowInterface;
import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.models.Step;

//  TODO- document
public class RecipeActivity extends AppCompatActivity implements RecipeMasterDetailFlowInterface {
    private Recipe recipe;
    private RecipeStepsListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        recipe = intent.getParcelableExtra(getString(R.string.extra_key_for_recipe));

        Fragment fragment = new RecipeStepsListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.recipe_steps_list_fragment, fragment)
                .commit();
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public void onSelectedStep(Step step) {
        Toast.makeText(this, step.getDescription(), Toast.LENGTH_SHORT).show();
    }
}
