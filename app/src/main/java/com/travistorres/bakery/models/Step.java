/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * Step
 *
 * Contains information regarding a step in a Recipe.
 *
 * @author Travis Anthony Torres
 * @version June 10, 2017
 */

//  TODO:  test parcelablility
public class Step implements Parcelable {
    private int id;
    private String description;
    private String shortDescription;
    private String thumbnailURL;
    private String videoURL;

    /**
     * Creates a Step in the recipe.
     *
     * @param id
     * @param shortDescription
     * @param description
     * @param videoURL
     * @param thumbnailUrl
     */
    public Step(int id, String shortDescription, String description,
                @Nullable String videoURL, @Nullable String thumbnailUrl) {
        this.id = id;
        setShortDescription(shortDescription);
        setDescription(description);
        setVideoUrl(videoURL);
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
     * @return videoURL
     */
    public String getVideoUrl() {
        return videoURL;
    }

    /**
     * Allows the URL for the video to be set.
     *
     * @param videoUrl
     */
    public void setVideoUrl(@Nullable String videoUrl) {
        this.videoURL = videoUrl;
    }

    /**
     * Retrieves the thumbnail url.
     *
     * @return thumbnail
     */
    public String getThumbnailUrl() {
        return thumbnailURL;
    }

    /**
     * Specifies the URL that contains the thumbnail for the step.
     *
     * @param thumbnailUrl
     */
    public void setThumbnailUrl(@Nullable String thumbnailUrl) {
        this.thumbnailURL = thumbnailUrl;
    }

    /**
     * Represent the Step as a string by displaying the shortDescription.
     *
     * @return Short Description
     */
    @Override
    public String toString() {
        return shortDescription;
    }

    /**
     * Provides a way to rebuild a Step from a Parcel.
     *
     */
    public static final Parcelable.Creator<Step> CREATOR = new Parcelable.Creator<Step>() {
        /**
         * Re-instantiates a Step from a Parcel.
         *
         * @param source
         *
         * @return Creates a new Step from the Parcel constructor
         */
        @Override
        public Step createFromParcel(Parcel source) {
            return new Step(source);
        }

        /**
         * Creates an array of Steps
         *
         * @param size
         *
         * @return Array of Steps
         */
        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };

    /**
     * Reconstructs a Step from a parcel.
     *
     * @param parcel
     */
    public Step(Parcel parcel) {
        id = parcel.readInt();
        shortDescription = parcel.readString();
        description = parcel.readString();
        videoURL = parcel.readString();
        thumbnailURL = parcel.readString();
    }

    /**
     * Describes the contents of a Parcel.
     *
     * @return zero
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Stores the contents of the Step into a Parcel for use later.
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(shortDescription);
        dest.writeString(description);
        dest.writeString(videoURL);
        dest.writeString(thumbnailURL);
    }
}
