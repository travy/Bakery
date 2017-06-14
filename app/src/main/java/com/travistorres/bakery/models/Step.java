/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import android.support.annotation.Nullable;

/**
 * Step
 *
 * Contains information regarding a step in a Recipe.
 *
 * @author Travis Anthony Torres
 * @version June 10, 2017
 */

public class Step {
    private int id;
    private String shortDescription;
    private String description;
    private String videoUrl;
    private String thumbnailUrl;

    /**
     * Creates a Step in the recipe.
     *
     * @param id
     * @param shortDescription
     * @param description
     * @param videoUrl
     * @param thumbnailUrl
     */
    public Step(int id, String shortDescription, String description,
                @Nullable String videoUrl, @Nullable String thumbnailUrl) {
        this.id = id;
        setShortDescription(shortDescription);
        setDescription(description);
        setVideoUrl(videoUrl);
        setThumbnailUrl(thumbnailUrl);
    }

    /**
     * Retrieves the data id field.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the short Description for the movie.
     *
     * @return short description
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the short description.
     *
     * @param shortDescription
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Retrieves the description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the long description which explains the step in the recipe.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the URL for the video.
     *
     * @return videoUrl
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * Allows the URL for the video to be set.
     *
     * @param videoUrl
     */
    public void setVideoUrl(@Nullable String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * Retrieves the thumbnail url.
     *
     * @return thumbnail
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Specifies the URL that contains the thumbnail for the step.
     *
     * @param thumbnailUrl
     */
    public void setThumbnailUrl(@Nullable String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
