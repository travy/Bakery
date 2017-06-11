/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * RecipeTest
 *
 * Performs Test on all aspects of the Recipe.
 *
 * @author Travis Anthony Torres
 * @version June 11, 2017
 */

public class RecipeTest {
    /**
     * Constructs an ingredient which can be used for all tests.
     *
     */
    @Before
    public void setUp() {

    }

    /**
     * Destroys the ingredient after each test.
     *
     */
    @After
    public void tearDown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecipeInstantiationThrowsExceptionWithInvalidArrayIngredients() {
        Assert.fail("Not implemented.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecipeInstantiatedThrowsExceptionWithInvalidArraySteps() {
        Assert.fail("Not Implemented.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecipeInstantiationThrowsExceptionWithInvalidCollectionIngredients() {
        Assert.fail("Not implemented.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecipeInstantiatedThrowsExceptionWithInvalidCollectionSteps() {
        Assert.fail("Not Implemented.");
    }

    @Test
    public void testGetDishFunctioning() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testSetDishWorks() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testGetIngredientsWorks() {
        Assert.fail("Not implemented.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIngredientsThrowsExceptionWithInvalidCollection() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testSetIngredientsWorksWithCollection() {
        Assert.fail("Not implemented.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIngredientsThrowsExceptionWithInvalidArray() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testSetIngredientsWithArray() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testGetStepsRetrievesCorrectValue() {
        Assert.fail("Not implemented.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStepsThrowsExceptionWithInvalidCollection() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testStepsCanBeSetUsingCollection() {
        Assert.fail("Not implemented.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStepsThrowsExceptionWithInvalidArray() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testStepsCanBeSetUsingArray() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testNumberOfStepsIsCorrect() {
        Assert.fail("Not implemented.");
    }
}
