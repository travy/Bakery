package com.travistorres.bakery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.networking.bakery.BakeryResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExperimentalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimental);

        GsonConverterFactory factory = GsonConverterFactory.create();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://d17h27t6h515a5.cloudfront.net")
                .addConverterFactory(factory);
        Retrofit retrofit = builder.build();

        BakeryResource client = retrofit.create(BakeryResource.class);
        Call<List<Recipe>> call = client.getRecipeList();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                Log.d("Network Request", "Network operation completed");
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.d("Failed Network Request", "Failed:  " + t.getMessage());
            }
        });
    }
}
