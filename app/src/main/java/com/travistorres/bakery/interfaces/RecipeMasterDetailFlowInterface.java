/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.interfaces;

import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.models.Step;

/**
 * RecipeMasterDetailFlowInterface
 *
 * Provides an interface that will allow for information to be shared between a master and detail
 * fragment.
 *
 * @author Travis Anthony Torres
 * @version August 20, 2017
 */

public interface RecipeMasterDetailFlowInterface {
    /**
     * Retrieves the Recipe object currently in use.
     *
     * @return selected recipe
     */
    Recipe getRecipe();

    /**
     * Specifies an operation to perform when a Step is selected.
     *
     * @param step
     */
    void onSelectedStep(Step step);

    /**
     * Specifies what to do when a user request the next step.
     *
     */
    void onSelectNextStep();

    /**
     * Specifies what to do when a user request the previous step.
     *
     */
    void onSelectPreviousStep();

    /**
     * Determines if there is another step to prepare the Recipe.
     *
     * @return whether or not there is another step
     */
    boolean hasNextStep();

    /**
     * Determines if there was a Step prior to the currently selected one.
     *
     * @return whether or note there was a Step prior to the current one
     */
    boolean hasPreviousStep();
}
