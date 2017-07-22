/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.activities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
}
