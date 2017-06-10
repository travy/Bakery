/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import android.support.annotation.Nullable;

/**
 * Dish
 *
 * Data model which represents a cooking Dish.  Information such as the name of the dish, image
 * and how many servings are provided can be acquired through its data layer.
 *
 * @author Travis Anthony Torres
 * @version June 10, 2017
 */

public class Dish {
    private int id;
    private String name;
    private int servings;
    private String image;

    /**
     * Constructs a new Dish with all of the pertinent information.
     *
     * @param id
     * @param name
     * @param servings
     * @param image
     *
     * @throws IllegalArgumentException When the serving size is less than 1
     */
    public Dish(int id, String name, int servings, @Nullable String image)
            throws IllegalArgumentException {
        this.id = id;
        setName(name);
        setServings(servings);
        setImage(image);
    }

    /**
     * Returns the name of the Dish when a String representation of the object is neeeded.
     *
     * @return name
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Retrieves the id for the Dish.
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the name for the dish.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the Dish
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the servings size.
     *
     * @return servings
     */
    public int getServings() {
        return this.servings;
    }

    /**
     * Sets the number of servings the Dish provides.
     *
     * @param servings Number of servings provided.
     *
     * @throws IllegalArgumentException When the servings size is less than 1
     */
    public void setServings(int servings)
            throws IllegalArgumentException {
        //  servings can be no smaller than 1
        if (servings <= 0) {
            throw new IllegalArgumentException("Invalid number of servings provided from a Dish.");
        }

        this.servings = servings;
    }

    /**
     * Retrieves the value for the image.
     *
     * @return Image
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Specifies the Image value.
     *
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }
}
