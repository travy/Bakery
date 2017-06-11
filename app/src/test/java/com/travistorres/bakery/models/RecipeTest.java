/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * RecipeTest
 *
 * Performs Test on all aspects of the Recipe.
 *
 * @author Travis Anthony Torres
 * @version June 11, 2017
 */

public class RecipeTest {
    private Dish dish;
    private Ingredient[] ingredients;
    private Step[] steps;
    private Recipe recipe;

    /**
     * Constructs an ingredient which can be used for all tests.
     *
     */
    @Before
    public void setUp() {
        this.dish = mock(Dish.class);

        Ingredient[] ingredients = new Ingredient[3];
        ingredients[0] = mock(Ingredient.class);
        ingredients[1] = mock(Ingredient.class);
        ingredients[2] = mock(Ingredient.class);
        this.ingredients = ingredients;

        Step steps[] = new Step[3];
        steps[0] = mock(Step.class);
        steps[1] = mock(Step.class);
        steps[2] = mock(Step.class);
        this.steps = steps;

        this.recipe = new Recipe(
                this.dish,
                this.ingredients,
                this.steps
        );
    }

    /**
     * Destroys the ingredient after each test.
     *
     */
    @After
    public void tearDown() {
        this.dish = null;
        this.ingredients = null;
        this.steps = null;
        this.recipe = null;
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
