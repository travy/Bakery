/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.utils.parcels;

import android.os.Parcel;

import java.lang.reflect.Array;

/**
 * ParcelReaderUtil
 *
 * Provides a set of procedures for reading data that is somewhat complicated to acquire from a
 * Parcel under normal circumstances.
 *
 * @author Travis Anthony Torres
 * @version August 12, 2017
 */

public class ParcelReaderUtil {
    /**
     * Utilizes reflection to reconstruct array based information that is read from a Parcel object
     * at runtime.
     *
     * @param parcel
     * @param dataClass
     *
     * @return Array of data that was read from a Parcel
     */
    public static Object[] readArrayFromParcel(Parcel parcel, Class dataClass) {
        ClassLoader loader = dataClass.getClassLoader();
        Object[] parcelData = parcel.readArray(loader);
        Object readArray = Array.newInstance(dataClass, parcelData.length);

        for (int i = 0; i < parcelData.length; ++i) {
            Object newData = parcelData[i];
            Array.set(readArray, i, newData);
        }

        return (Object[]) readArray;
    }
}
