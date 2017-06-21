/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.activities;

import com.travistorres.bakery.models.Recipe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * RecipeListActivityTest
 *
 * Performs test operations on all methods used within the RecipeListActivity.
 *
 * @author Travis Anthony Torres
 * @version June 21, 2017
 */

public class RecipeListActivityTest {
    private RecipeListActivity activity;

    /**
     * Sets up any shared resources before each test is performed.
     *
     */
    @Before
    public void setUp() {
        activity = new RecipeListActivity();
    }

    /**
     * Clears out the test environment after each test has completed.
     *
     */
    @After
    public void tearDown() {
        activity = null;
    }

    /**
     * Test that when the RecipeListActivity completes, that a list of recipes is allocated memory.
     *
     */
    @Test
    public void testRecipeListActivityLoadsListOfRecipes() {
        fail("Not implemented.");
    }

    /**
     * Each of the view items in the layout resource should be mapped to some instance variable
     * so that it can be controlled by the Activity.
     *
     */
    @Test
    public void testRecipeListActivityMapsAllInterfaceViewsToInstanceVariable() {
        fail("Not implemented.");
    }

    /**
     * Old list of Recipes should be replaced by the newly loaded list.
     *
     */
    @Test
    public void testSetRecipeReplacesOldList() {
        fail("Not implemented.");
    }

    /**
     * A value of false should be returned on bad input.
     *
     */
    @Test
    public void testSetRecipeReturnsFalseOnNullInput() {
        fail("Not implemented.");
    }

    /**
     * A value of true should be returned on valid input.
     *
     */
    @Test
    public void testSetRecipeReturnsTrueWithValidResults() {
        fail("Not implemented.");
    }

    /**
     * When <em>getRecipe()</em> is called, the <em>List</em> value returned should not have the
     * same reference id.  This is to prevent manipulation of data from an external source.
     *
     */
    @Test
    public void testGetRecipeReturnedListIsNotSameObjectInMemory() {
        fail("Not implemented.");
    }

    /**
     * The returned <em>List</em> should have all <em>Recipe</em> objects as in the
     * <em>recipes</em> instance variable.
     *
     */
    @Test
    public void testGetRecipeRetrievesAnExactCopyOfRecipeList() {
        fail("Not implemented.");
    }

    /**
     * <em>getRecipe()</em> should return a copy of the value just set by <em>setRecipe()</em>.
     *
     */
    @Test
    public void testGetRecipeRetrievesSameResultsAfterSetRecipeCall() {
        fail("Not implemented.");
    }

    /**
     * When no list of Recipes is provided, the value returned should still be zero.
     *
     */
    @Test
    public void testGetNumberOfRecipesIsZeroWhenGetRecipesIsNull() {
        fail("Not implemented.");
    }

    /**
     * Method call should return the correct count of items.
     *
     */
    @Test
    public void testGetNumberOrRecipesReturnsCorrectValue() {
        fail("Not implemented.");
    }
}
