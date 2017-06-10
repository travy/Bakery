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
        Assert.assertEquals(DEFAULT_SHARED_ID, step.getId());
    }

    @Test
    public void testGetShortDescriptionRetrievesValue() {
        Assert.assertEquals(DEFAULT_SHARED_SHORT_DESCRIPTION, step.getShortDescription());
    }

    @Test
    public void testSetShortDescriptionSetsValue() {
        String newShortDescription = DEFAULT_SHARED_SHORT_DESCRIPTION + " this is new";
        step.setShortDescription(newShortDescription);

        Assert.assertEquals(newShortDescription, step.getShortDescription());
    }

    @Test
    public void testGetDescriptionRetrievesValue() {
        Assert.assertEquals(DEFAULT_SHARED_DESCRIPTION, step.getDescription());
    }

    @Test
    public void testSetDescriptionSetsValue() {
        String newDescription = DEFAULT_SHARED_DESCRIPTION + " this is new";
        step.setDescription(newDescription);

        Assert.assertEquals(newDescription, step.getDescription());
    }

    @Test
    public void testGetVideoUrlRetrievesValue() {
        Assert.assertEquals(DEFAULT_SHARED_VIDEO_URL, step.getVideoUrl());
    }

    @Test
    public void testSetVideoUrlSetsValue() {
        String newVideoUrl = DEFAULT_SHARED_VIDEO_URL + " another url";
        step.setVideoUrl(newVideoUrl);

        Assert.assertEquals(newVideoUrl, step.getVideoUrl());
    }

    @Test
    public void testGetThumbnailUrlRetrievesValue() {
        Assert.assertEquals(DEFAULT_SHARED_THUMBNAIL_URL, step.getThumbnailUrl());
    }

    @Test
    public void testSetThumbnailUrlIsWorking() {
        String newThumbnailUrl = DEFAULT_SHARED_THUMBNAIL_URL + " another url";
        step.setThumbnailUrl(newThumbnailUrl);

        Assert.assertEquals(newThumbnailUrl, step.getThumbnailUrl());
    }
}
