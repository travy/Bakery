/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * IngredientTest
 *
 * Test out all of the operations that are performed on the Ingredient model.
 *
 * @author Travis Anthony Torres
 * @version June 10, 2017
 */

public class IngredientTest {
    private static final int DEFAULT_SHARED_QUANTITY = 5;
    private static final String DEFAULT_SHARED_MEASURE = "Cups";
    private static final String DEFAULT_SHARED_INGREDIENT = "Flour";

    private Ingredient ingredient;

    /**
     * Constructs an ingredient which can be used for all tests.
     *
     */
    @Before
    public void setUp() {
        ingredient = new Ingredient(
                DEFAULT_SHARED_QUANTITY,
                DEFAULT_SHARED_MEASURE,
                DEFAULT_SHARED_INGREDIENT
        );
    }

    /**
     * Destroys the ingredient after each test.
     *
     */
    @After
    public void tearDown() {
        ingredient = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIngredientInstantiateThrowsExceptionOnZeroQuantity() {
        Ingredient someIngredient = new Ingredient(
                0,
                "Measure",
                "Ingredient"
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIngredientInstantiateThrowsExceptionOnNegativeQuantity() {
        Ingredient someIngredient = new Ingredient(
                -1,
                "Measure",
                "Ingredient"
        );
    }

    @Test
    public void testGetQuantityRetrievesCorrectValue() {
        Assert.assertEquals(DEFAULT_SHARED_QUANTITY, ingredient.getQuantity(), 0.0);
    }

    @Test
    public void testSetQuantityOperatesCorrectly() {
        int newQuantity = DEFAULT_SHARED_QUANTITY * 5;
        ingredient.setQuantity(newQuantity);

        Assert.assertEquals(newQuantity, ingredient.getQuantity(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantityThrowsExceptionWhenZero() {
        ingredient.setQuantity(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantityThrowsExceptionWhenNegative() {
        ingredient.setQuantity(-1);
    }

    @Test
    public void testGetMeasureRetrievesCorrectValue() {
        Assert.assertEquals(DEFAULT_SHARED_MEASURE, ingredient.getMeasure());
    }

    @Test
    public void testSetMeasureOperatesCorrectly() {
        String newMeasure = "A brand new Measure";
        ingredient.setMeasure(newMeasure);

        Assert.assertEquals(newMeasure, ingredient.getMeasure());
    }

    @Test
    public void testGetIngredientRetrievesValue() {
        Assert.assertEquals(DEFAULT_SHARED_INGREDIENT, ingredient.getIngredient());
    }

    @Test
    public void testSetIngredientWorksCorrectly() {
        String newIngredient = "This is a new ingredient";
        ingredient.setIngredient(newIngredient);

        Assert.assertEquals(newIngredient, ingredient.getIngredient());
    }
}
