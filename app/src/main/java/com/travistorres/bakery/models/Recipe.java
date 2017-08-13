/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.travistorres.bakery.utils.parcels.ParcelReaderUtil;

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

//  TODO:  test parcelability
public class Recipe implements Parcelable {
    private double servings;
    private Ingredient[] ingredients;
    private int id;
    private Step[] steps;
    private String image;
    private String name;

    /**
     * Constructs a new Recipe.
     *
     * @param id
     * @param name
     * @param servings
     * @param image
     * @param ingredients
     * @param steps
     *
     * @throws IllegalArgumentException When either the ingredients or steps is empty.
     */
    public Recipe(int id, String name, double servings, @Nullable String image,
                  Ingredient[] ingredients, Step[] steps) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.image = image;

        setIngredients(ingredients);
        setSteps(steps);
    }

    /**
     * Constructs a new Recipe with step by step instructions and an ingredients list.
     *
     * @param id
     * @param name
     * @param servings
     * @param image
     * @param ingredients
     * @param steps
     *
     * @throws IllegalArgumentException When either the ingredients or steps is empty.
     */
    public Recipe(int id, String name, double servings, @Nullable String image,
                  Collection<Ingredient> ingredients, Collection<Step> steps) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.image = image;

        setIngredients(ingredients);
        setSteps(steps);
    }

    /**
     * Reconstructs a Recipe object using data acquired from a Parcel.
     *
     * @param parcel
     */
    private Recipe(Parcel parcel) {
        id = parcel.readInt();
        name = parcel.readString();
        servings = parcel.readDouble();
        image = parcel.readString();
        ingredients = (Ingredient[]) ParcelReaderUtil.readArrayFromParcel(parcel, Ingredient.class);
        steps = (Step[]) ParcelReaderUtil.readArrayFromParcel(parcel, Step.class);
    }

    /**
     * Retrieves the database id for the dish.
     *
     * @return id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retrieves the name of the dish.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Specifies the name of the recipe.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Acquires the number of servings provided.
     *
     * @return servings
     */
    public double getServings() {
        return this.servings;
    }

    /**
     * Specifies the number of servings provided.
     *
     * @param servings
     */
    public void setServings(double servings) {
        this.servings = servings;
    }

    /**
     * Acquires the image resource.
     *
     * @return image
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Specifies the image resource.
     *
     * @param image
     */
    public void setImage(@Nullable String image) {
        this.image = image;
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

    /**
     * Full description of the Recipe.
     *
     * @return Returns the name of the dish.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Builds a new Recipe from a Parcel.
     *
     */
    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        /**
         * Builds a single Recipe item.
         *
         * @param source
         *
         * @return Rebuilt Recipe from Parcel
         */
        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        /**
         * Constructs an array of Recipes.
         *
         * @param size
         *
         * @return Array of recipes
         */
        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    /**
     * Describes the contents of the Parcel.
     *
     * @return zero
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Stores contents of the Recipe into a parcel for use later.
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeDouble(servings);
        dest.writeString(image);
        dest.writeArray(ingredients);
        dest.writeArray(steps);
    }

    /**
     * Retrieves the number of ingredients required by the Recipe.
     *
     * @return number of Ingredients
     */
    public int getNumberOfIngredients() {
        return ingredients.length;
    }
}
