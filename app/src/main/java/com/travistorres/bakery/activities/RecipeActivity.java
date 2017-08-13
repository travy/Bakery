package com.travistorres.bakery.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.travistorres.bakery.R;
import com.travistorres.bakery.fragments.RecipeStepsListFragment;
import com.travistorres.bakery.models.Recipe;

public class RecipeActivity extends AppCompatActivity {
    private Recipe recipe;
    private RecipeStepsListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        recipe = intent.getParcelableExtra(getString(R.string.extra_key_for_recipe));

        Bundle bundle = new Bundle();
        bundle.putParcelable(getString(R.string.extra_key_for_recipe), recipe);
        Fragment fragment = new RecipeStepsListFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.recipe_steps_list_fragment, fragment)
                .commit();
    }
}
