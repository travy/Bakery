/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

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
    public static final int DEFAULT_SHARED_DISH_ID = 8;
    public static final String DEFAULT_SHARED_DISH_NAME = "Apple Pie";
    public static final double DEFAULT_SHARED_DISH_SERVINGS = 3;
    public static final String DEFAULT_SHARED_IMAGE = null;

    private Ingredient[] ingredients;
    private Step[] steps;
    private Recipe recipe;

    /**
     * Constructs an ingredient which can be used for all tests.
     *
     */
    @Before
    public void setUp() {
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
                DEFAULT_SHARED_DISH_ID,
                DEFAULT_SHARED_DISH_NAME,
                DEFAULT_SHARED_DISH_SERVINGS,
                DEFAULT_SHARED_IMAGE,
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
        this.ingredients = null;
        this.steps = null;
        this.recipe = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecipeInstantiationThrowsExceptionWithInvalidArrayIngredients() {
        Ingredient[] ingredients = new Ingredient[0];
        Recipe recipe = new Recipe(
                DEFAULT_SHARED_DISH_ID,
                DEFAULT_SHARED_DISH_NAME,
                DEFAULT_SHARED_DISH_SERVINGS,
                DEFAULT_SHARED_IMAGE,
                ingredients,
                this.steps
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecipeInstantiatedThrowsExceptionWithInvalidArraySteps() {
        Step[] newSteps = new Step[0];
        Recipe newRecipe = new Recipe(
                DEFAULT_SHARED_DISH_ID,
                DEFAULT_SHARED_DISH_NAME,
                DEFAULT_SHARED_DISH_SERVINGS,
                DEFAULT_SHARED_IMAGE,
                this.ingredients,
                newSteps
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecipeInstantiationThrowsExceptionWithInvalidCollectionIngredients() {
        Collection<Ingredient> newIngredients = mock(ArrayList.class);
        when(newIngredients.toArray())
                .thenReturn(new Ingredient[0]);

        Collection<Step> newSteps = mock(ArrayList.class);
        when(newSteps.toArray())
                .thenReturn(new Step[] {
                        mock(Step.class),
                        mock(Step.class),
                        mock(Step.class)
                });

        Recipe newRecipe = new Recipe(
                DEFAULT_SHARED_DISH_ID,
                DEFAULT_SHARED_DISH_NAME,
                DEFAULT_SHARED_DISH_SERVINGS,
                DEFAULT_SHARED_IMAGE,
                newIngredients,
                newSteps);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecipeInstantiatedThrowsExceptionWithInvalidCollectionSteps() {
        Collection<Step> newSteps = mock(ArrayList.class);
        when(newSteps.toArray())
                .thenReturn(new Step[0]);

        Collection<Ingredient> newIngredients = mock(ArrayList.class);
        when(newIngredients.toArray())
                .thenReturn(new Ingredient[] {
                        mock(Ingredient.class),
                        mock(Ingredient.class)
                });

        Recipe newRecipe = new Recipe(
                DEFAULT_SHARED_DISH_ID,
                DEFAULT_SHARED_DISH_NAME,
                DEFAULT_SHARED_DISH_SERVINGS,
                DEFAULT_SHARED_IMAGE,
                newIngredients,
                newSteps
        );
    }

    @Test
    public void testGetIngredientsWorks() {
        assertEquals(this.ingredients, this.recipe.getIngredients());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIngredientsThrowsExceptionWithInvalidCollection() {
        Collection<Ingredient> newCollection = mock(ArrayList.class);
        when(newCollection.toArray())
                .thenReturn(new Ingredient[0]);

        this.recipe.setIngredients(newCollection);
    }

    @Test
    public void testSetIngredientsWorksWithCollection() {
        Collection<Ingredient> newCollection = mock(Collection.class);
        when(newCollection.toArray())
                .thenReturn(new Ingredient [] {
                    mock(Ingredient.class),
                    mock(Ingredient.class)
                });

        this.recipe.setIngredients(newCollection);

        assertEquals(newCollection.toArray(), this.recipe.getIngredients());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIngredientsThrowsExceptionWithInvalidArray() {
        Ingredient[] newIngredients = new Ingredient[0];
        this.recipe.setIngredients(newIngredients);
    }

    @Test
    public void testSetIngredientsWithArray() {
        Ingredient[] newIngredients = new Ingredient[3];
        newIngredients[0] = mock(Ingredient.class);
        newIngredients[1] = mock(Ingredient.class);
        newIngredients[2] = mock(Ingredient.class);

        this.recipe.setIngredients(newIngredients);

        assertEquals(newIngredients, this.recipe.getIngredients());
    }

    @Test
    public void testGetStepsRetrievesCorrectValue() {
        assertEquals(this.steps, this.recipe.getSteps());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStepsThrowsExceptionWithInvalidCollection() {
        Collection<Step> newSteps = mock(ArrayList.class);
        when(newSteps.toArray())
                .thenReturn(new Step[0]);

        this.recipe.setSteps(newSteps);
    }

    @Test
    public void testSetStepsCanBeSetUsingCollection() {
        Collection<Step> newSteps = mock(ArrayList.class);
        when(newSteps.toArray())
                .thenReturn(new Step[] {
                        mock(Step.class)
                });

        this.recipe.setSteps(newSteps);

        assertEquals(newSteps.toArray(), this.recipe.getSteps());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetStepsThrowsExceptionWithInvalidArray() {
        Step[] newSteps = new Step[0];
        this.recipe.setSteps(newSteps);
    }

    @Test
    public void testSetStepsCanBeSetUsingArray() {
        int numSteps = 3;
        Step[] newSteps = new Step[numSteps];
        for (int i = 0; i < newSteps.length; ++i) {
            newSteps[i] = mock(Step.class);
        }

        this.recipe.setSteps(newSteps);

        assertEquals(newSteps, this.recipe.getSteps());
    }

    @Test
    public void testNumberOfStepsIsCorrect() {
        int numSteps = this.steps.length;
        assertEquals(numSteps, this.recipe.numberOfSteps());
    }

    @Test
    public void testToStringReturnsNameOfDish() {
        String stringOfRecipe = recipe.toString();

        assertEquals(DEFAULT_SHARED_DISH_NAME, stringOfRecipe);
    }

    @Test
    public void testGetIdRetrievesCorrectValue() {
        assertEquals(DEFAULT_SHARED_DISH_ID, recipe.getId());
    }

    @Test
    public void testGetNameRetrievesCorrectValue() {
        assertEquals(DEFAULT_SHARED_DISH_NAME, recipe.getName());
    }

    @Test
    public void testSetNameFunctionsCorrectly() {
        String newName = "Pizza with Bacon Bits";
        assertNotEquals(newName, recipe.getName());

        recipe.setName(newName);

        assertEquals(newName, recipe.getName());
    }

    @Test
    public void testGetServingsRetrievesTheCorrectValue() {
        assertEquals(DEFAULT_SHARED_DISH_SERVINGS, recipe.getServings(), 0.0);
    }

    @Test
    public void testSetServingsFunctionsCorrectly() {
        double newServings = 8.0;
        assertNotEquals(newServings, recipe.getServings(), 0.0);

        recipe.setServings(newServings);
        assertEquals(newServings, recipe.getServings(), 0.0);
    }

    @Test
    public void testGetImageReturnsCorrectValue() {
        assertEquals(DEFAULT_SHARED_IMAGE, recipe.getImage());
    }

    @Test
    public void testSetImageSetsCorrectValue() {
        String newImage = "Flabbergastered.bmp";
        assertNotEquals(newImage, recipe.getImage());

        recipe.setImage(newImage);
        assertEquals(newImage, recipe.getImage());
    }
}
