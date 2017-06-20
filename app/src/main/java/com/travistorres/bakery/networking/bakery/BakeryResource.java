/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.networking.bakery;

import com.travistorres.bakery.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * BakeryResource
 *
 * Establishes a connection with a RESTful server for acquiring a list of Recipes.
 *
 * @author Travis Anthony Torres
 * @version June 19, 2017
 */

public interface BakeryResource {
    /**
     * Retrieves a list of all Recipes from the RESTful server.
     *
     * @return List of all Recipes
     */
    @GET("/topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> getRecipeList();
}
