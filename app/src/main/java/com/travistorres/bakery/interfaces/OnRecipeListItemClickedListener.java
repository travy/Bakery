/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.interfaces;

import com.travistorres.bakery.models.Recipe;

/**
 * OnRecipeListItemClickedListener
 *
 * Specifies what to do when a Recipe object has been clicked.
 *
 * @author Travis Anthony Torres
 * @version August 13, 2017
 */

public interface OnRecipeListItemClickedListener {
    /**
     * Provides a handle to a Recipe that has been clicked.
     *
     * @param recipe
     */
    void onClick(Recipe recipe);
}
