/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DishTest
 *
 * Test all methods are implemented correctly in the Dish data model.
 *
 * @author Travis Anthony Torres
 * @version June 10, 2017
 */

public class DishTest {
    private static final int DEFAULT_SHARED_DISH_ID = 1;
    private static final String DEFAULT_SHARED_DISH_NAME = "Cookie";
    private static final int DEFAULT_SHARED_DISH_SERVINGS = 6;
    private static final String DEFAULT_SHARED_DISH_IMAGE = null;

    private Dish dish;

    /**
     * Creates a dish object which can be used by all testing facilities.
     *
     */
    @Before
    public void setUp() {
        dish = new Dish(
                DEFAULT_SHARED_DISH_ID,
                DEFAULT_SHARED_DISH_NAME,
                DEFAULT_SHARED_DISH_SERVINGS,
                DEFAULT_SHARED_DISH_IMAGE);
    }

    /**
     * Releases any globally shared memory objects.
     *
     */
    @After
    public void tearDown() {
        dish = null;
    }

    /**
     * Checks functionality works.
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInstantiatedObjectFailsOnZeroServings() {
        Dish newDish = new Dish(
                DEFAULT_SHARED_DISH_ID + 3,
                DEFAULT_SHARED_DISH_NAME + "Atomic",
                0,
                "Some Image Resource"
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInstantiatedObjectFailsOnNegativeServings() {
        Dish newDish = new Dish(
                DEFAULT_SHARED_DISH_ID + 3,
                DEFAULT_SHARED_DISH_NAME + "Atomic",
                -2,
                "Some Image Resource"
        );
    }

    /**
     * Checks functionality works.
     *
     */
    @Test
    public void testToStringReturnsSameValueAsGetName() {
        Assert.assertEquals(dish.getName(), dish.toString());
    }

    /**
     * Checks functionality works.
     *
     */
    @Test
    public void testGetIdRetrievesTheMovieId() {
        Assert.assertEquals(DEFAULT_SHARED_DISH_ID, dish.getId());
    }

    /**
     * Checks functionality works.
     *
     */
    @Test
    public void testGetNameRetrievesTheCorrectName() {
        Assert.assertEquals(DEFAULT_SHARED_DISH_NAME, dish.getName());
    }

    /**
     * Checks functionality works.
     *
     */
    @Test
    public void testSetNameSpecifiesTheCorrectName() {
        String newName = "Snickerdoodle";
        dish.setName(newName);
        Assert.assertEquals(newName, dish.getName());
    }

    /**
     * Checks functionality works.
     *
     */
    @Test
    public void testGetServingsWorksAsExpected() {
        Assert.assertEquals(DEFAULT_SHARED_DISH_SERVINGS, dish.getServings());
    }

    /**
     * Checks the error checking system throws an Exception on faulty input.
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetServingsThrowsExceptionWhenServingsIsZero() {
        dish.setServings(0);
    }

    /**
     * Can't have negative servings.
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetServingsThrowsExceptionWhenServingsIsNegative() {
        dish.setServings(-1);
    }

    /**
     * Checks functionality works.
     *
     */
    @Test
    public void testSetServingsSetsServingsSize() {
        int newServingsSize = DEFAULT_SHARED_DISH_SERVINGS * 3;
        dish.setServings(newServingsSize);
        Assert.assertEquals(newServingsSize, dish.getServings());
    }

    /**
     * Checks functionality works.
     *
     */
    @Test
    public void testGetImageRetrievesTheImageValue() {
        Assert.assertEquals(DEFAULT_SHARED_DISH_IMAGE, dish.getImage());
    }

    /**
     * Checks functionality works.
     *
     */
    @Test
    public void testSetImageChangesImageValue() {
        String newImage = "Some Image Value";
        dish.setImage(newImage);

        Assert.assertEquals(newImage, dish.getImage());
    }
}
