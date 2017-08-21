/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.networking.loaders;

import com.travistorres.bakery.interfaces.BakeryResource;
import com.travistorres.bakery.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * RecipeLoader
 *
 * Responsible for loading a List of Recipes from some external URL resource.
 *
 * @author Travis Anthony Torres
 * @version July 12, 2017
 */

public class RecipeLoader {
    /**
     * Acquires a Retrofit object which will load Recipe objects from the resource hosted on the
     * specified url.  The provided factory converter will translate the data from the server into
     * a valid Recipe object.
     *
     * @param url
     * @param factory
     *
     * @return Retrofit object for describing how to map results to a Recipe.
     */
    public Retrofit getRetrofitObject(String url, Converter.Factory factory) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder
                .baseUrl(url)
                .addConverterFactory(factory);

        return builder.build();
    }

    /**
     * Loads resources from an external resource defined within the Retrofit object parameter.
     * Upon successful loading of the Recipes, the operations defined in the Callback object will
     * be performed.
     *
     * @param retrofit
     * @param callback
     */
    public void load(Retrofit retrofit, Callback<List<Recipe>> callback) {
        BakeryResource resource = retrofit.create(BakeryResource.class);
        Call<List<Recipe>> call = resource.getRecipeList();
        call.enqueue(callback);
    }

    /**
     * Will load the Recipes from a given url using a JSON factory converter class.  Upon
     * successful loading of the Recipes, the operations defined in the Callback object will be
     * performed.
     *
     * @param url
     * @param callback
     */
    public void loadWithGsonConverter(String url, Callback<List<Recipe>> callback) {
        Retrofit retrofit = getRetrofitObject(url, GsonConverterFactory.create());
        load(retrofit, callback);
    }
}
