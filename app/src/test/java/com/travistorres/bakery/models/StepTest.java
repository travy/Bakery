/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * StepTest
 *
 * Test all of the operations performed by the Step data model.
 *
 * @author Travis Anthony Torres
 * @version June 10, 2017
 */

public class StepTest {
    private static final int DEFAULT_SHARED_ID = 4;
    private static final String DEFAULT_SHARED_SHORT_DESCRIPTION = "short";
    private static final String DEFAULT_SHARED_DESCRIPTION = "description";
    private static final String DEFAULT_SHARED_VIDEO_URL = null;
    private static final String DEFAULT_SHARED_THUMBNAIL_URL = null;

    private Step step;

    /**
     * Constructs an ingredient which can be used for all tests.
     *
     */
    @Before
    public void setUp() {
        step = new Step(
                DEFAULT_SHARED_ID,
                DEFAULT_SHARED_SHORT_DESCRIPTION,
                DEFAULT_SHARED_DESCRIPTION,
                DEFAULT_SHARED_VIDEO_URL,
                DEFAULT_SHARED_THUMBNAIL_URL
        );
    }

    /**
     * Destroys the ingredient after each test.
     *
     */
    @After
    public void tearDown() {
        step = null;
    }

    @Test
    public void testGetIdRetrievesValue() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testGetShortDescriptionRetrievesValue() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testSetShortDescriptionSetsValue() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testGetDescriptionRetrievesValue() {
        Assert.fail("Not implemented");
    }

    @Test
    public void testSetDescriptionSetsValue() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testGetVideoUrlRetrievesValue() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testSetVideoUrlSetsValue() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testGetThumbnailUrlRetrievesValue() {
        Assert.fail("Not implemented.");
    }

    @Test
    public void testSetThumbnailUrlIsWorking() {
        Assert.fail("Not implemented");
    }
}
