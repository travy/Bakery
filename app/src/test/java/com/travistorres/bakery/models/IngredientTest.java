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
        Assert.fail("Not implemented");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIngredientInstantiateThrowsExceptionOnNegativeQuantity() {
        Assert.fail("Not imlemented");
    }

    @Test
    public void testGetQuantityRetrievesCorrectValue() {
        Assert.fail("Not implemented");
    }

    @Test
    public void testSetQuantityOperatesCorrectly() {
        Assert.fail("Not implemented");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantityThrowsExceptionWhenZero() {
        Assert.fail("Not implemented");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantityThrowsExceptionWhenNegative() {
        Assert.fail("Not implemented");
    }

    @Test
    public void testGetMeasureRetrievesCorrectValue() {
        Assert.fail("Not implemented");
    }

    @Test
    public void testSetMeasureOperatesCorrectly() {
        Assert.fail("Not implemented");
    }

    @Test
    public void testGetIngredientRetrievesValue() {
        Assert.fail("Not Implemented");
    }

    @Test
    public void testSetIngredientWorksCorrectly() {
        Assert.fail("Not Implemented");
    }
}
