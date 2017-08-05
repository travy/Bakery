/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Ingredient
 *
 * Contains information regarding a specific ingredient within a Recipe.
 *
 * @author Travis Anthony Torres
 * @version June 10, 2017s
 */

//  TODO:  write documentation
//  TODO:  test parcelability

public class Ingredient
        implements Parcelable {
    private double quantity;
    private String measure;
    private String ingredient;

    /**
     * Constructs a new Ingredient object.
     *
     * @param quantity
     * @param measure
     * @param ingredient
     *
     * @throws IllegalArgumentException When the value supplied for the quantity is less tha or
     * equal to zero.
     */
    public Ingredient(double quantity, String measure, String ingredient)
            throws IllegalArgumentException {
        setQuantity(quantity);
        setMeasure(measure);
        setIngredient(ingredient);
    }

    /**
     * Retrieves the quantity of the ingredient that is required.
     *
     * @return quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of ingredients required for a recipe.
     *
     * @param quantity
     *
     * @throws IllegalArgumentException When the quantity is less than or equal to zero.
     */
    public void setQuantity(double quantity)
            throws IllegalArgumentException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("The value specified for an Ingredients quantity must be greater than 0");
        }

        this.quantity = quantity;
    }

    /**
     * Acquires the unit of measure.
     *
     * @return measure
     */
    public String getMeasure() {
        return measure;
    }

    /**
     * Specifies the measure of the ingredient in a recipe.
     *
     * @param measure
     */
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    /**
     * Acquires the ingredients name.
     *
     * @return ingredient
     */
    public String getIngredient() {
        return ingredient;
    }

    /**
     * Specifies the ingredient that the object represents.
     *
     * @param ingredient
     */
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * Outputs the textual description for the ingredient.
     *
     * @return ingredient description
     */
    @Override
    public String toString() {
        return this.ingredient + " requires " + this.quantity + " " + this.measure;
    }

    public static Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient> () {
        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public Ingredient(Parcel parcel) {
        quantity = parcel.readDouble();
        measure = parcel.readString();
        ingredient = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(quantity);
        dest.writeString(measure);
        dest.writeString(ingredient);
    }
}
