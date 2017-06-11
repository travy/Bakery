/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import java.util.Collection;

/**
 * Recipe
 *
 * A Recipe provides all of the steps necessary for preparing a given Dish item.  A list of all
 * ingredients and correct order of the steps necessary to make the final product.
 *
 * @author Travis Anthony Torres
 * @version June 11, 2017
 */

public class Recipe {
    private Dish dish;
    private Ingredient[] ingredients;
    private Step[] steps;

    /**
     * Constructs a new Recipe with step by step instructions and an ingredients list.
     *
     * @param dish
     * @param ingredients
     * @param steps
     *
     * @throws IllegalArgumentException When either the ingredients or steps is empty.
     */
    public Recipe(Dish dish, Ingredient[] ingredients, Step[] steps) {
        setDish(dish);
        setIngredients(ingredients);
        setSteps(steps);
    }

    /**
     * Constructs a new Recipe with step by step instructions and an ingredients list.
     *
     * @param dish
     * @param ingredients
     * @param steps
     *
     * @throws IllegalArgumentException When either the ingredients or steps is empty.
     */
    public Recipe(Dish dish, Collection<Ingredient> ingredients, Collection<Step> steps) {
        setDish(dish);
        setIngredients(ingredients);
        setSteps(steps);
    }

    /**
     * Retrieves information regarding the dish.
     *
     * @return dish
     */
    public Dish getDish() {
        return dish;
    }

    /**
     * Sets information regarding the Dish.
     *
     * @param dish
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    /**
     * Retrieves a list of all ingredients in the Dish.
     *
     * @return ingredients
     */
    public Ingredient[] getIngredients() {
        return ingredients;
    }

    /**
     * Specifies the ingredients contained within the Dish.
     *
     * @param ingredients
     *
     * @throws IllegalArgumentException When no ingredients are specified.
     */
    public void setIngredients(Collection<Ingredient> ingredients)
            throws IllegalArgumentException {
        Ingredient[] ingredientsArray = (Ingredient[]) ingredients.toArray();
        setIngredients(ingredientsArray);
    }

    /**
     * Specifies all ingredients contained within the Recipe.
     *
     * @param ingredients
     *
     * @throws IllegalArgumentException When no ingredients are specified.
     */
    public void setIngredients(Ingredient[] ingredients)
            throws IllegalArgumentException {
        arrayValidator(ingredients, "No ingredients have been provided for the Recipe.");
        this.ingredients = ingredients;
    }

    /**
     * Retrieves all steps needed to create the Recipe.  The order of each steps persist as you
     * iterate through the results from index 0 to n.
     *
     * @return steps
     */
    public Step[] getSteps() {
        return steps;
    }

    /**
     * Specifies a collection which contains all of the steps to recreate the dish in order.
     *
     * @param steps
     *
     * @throws IllegalArgumentException When no steps are provided within the Collection.
     */
    public void setSteps(Collection<Step> steps)
            throws IllegalArgumentException {
        Step[] stepsArray = (Step[]) steps.toArray();
        setSteps(stepsArray);
    }

    /**
     * Specifies each step that is required to recreate the dish in order.
     *
     * @param steps
     *
     * @throws IllegalArgumentException When no steps are provided within the array.
     */
    public void setSteps(Step[] steps)
            throws IllegalArgumentException {
        arrayValidator(steps, "No steps have been provided for the Recipe.");

        this.steps = steps;
    }

    /**
     * Validates that an array is valid before storing it within the structure.
     *
     * @param array
     * @param message
     *
     * @throws IllegalArgumentException When the array is empty.
     */
    private void arrayValidator(Object[] array, String message)
            throws IllegalArgumentException {
        if (array.length <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Retrieves the number of steps for the Recipe.
     *
     * @return number of steps in recipe.
     */
    public int numberOfSteps() {
        return steps.length;
    }
}
