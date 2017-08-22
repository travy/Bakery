/**
 * Copyright (c) Travis Anthony Torres
 */

package com.travistorres.bakery.utils;

import com.travistorres.bakery.models.Step;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * RecipeStepsIterator
 *
 * Provides an interface for sequentially stepping through a list of Steps that are used to cook
 * a Recipe.
 *
 * @author Travis Anthony Torres
 * @version August 20, 2017
 */

public class RecipeStepsIterator implements ListIterator<Step> {
    private int index;
    private Step[] list;

    /**
     * Constructs a new Iterator which will track the sequence of Steps in a Recipe.
     *
     * @param stepList
     */
    public RecipeStepsIterator(Step[] stepList) {
        index = 0;
        list = stepList;
    }

    /**
     * Retrieves the current Step in the sequence.
     *
     * @return current Step
     */
    public Step getCurrent() {
        return list[index];
    }

    /**
     * Specifies the Step that should be set as the current Step in the sequence.
     *
     * @param step Step to select.
     *
     * @return Whether or not the Step could be set
     */
    public boolean setCurrent(Step step) {
        boolean wasSet = false;
        for (int i = 0; i < list.length; ++i) {
            Step listItem = list[i];
            if (listItem == step) {
                index = i;
                wasSet = true;
                break;
            }
        }

        return wasSet;
    }

    /**
     * Determines if there is another Step in the sequence.
     *
     * @return whether there is another Step
     */
    @Override
    public boolean hasNext() {
        return index < list.length - 1;
    }

    /**
     * Acquires the next Step in the sequence.
     *
     * @return next Step
     *
     * @throws NoSuchElementException There are no more Steps
     */
    @Override
    public Step next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return list[++index];
    }

    /**
     * Determines if there is a previous step.
     *
     * @return whether or not there is a previous step.
     */
    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    /**
     * Obtains the previous Step in the sequence.
     *
     * @return previous step
     *
     * @throws NoSuchElementException When there is no previous step
     */
    @Override
    public Step previous() throws NoSuchElementException {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }

        return list[--index];
    }

    /**
     * Identifies the index of the next Step in the sequence.
     *
     * @return The index for the next Step or the number of Steps if at the end of the sequence.
     */
    @Override
    public int nextIndex() {
        return index + 1;
    }

    /**
     * Identifies the index of the previous item in the sequence.
     *
     * @return The index of the Step that comes before the currently selected one or -1 if the
     * current Step is the first one.
     */
    @Override
    public int previousIndex() {
        return index - 1;
    }

    /**
     * Not supported.
     *
     * @throws NoSuchElementException
     */
    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Not supported.
     *
     * @param step
     *
     * @throws NoSuchElementException
     */
    @Override
    public void set(Step step) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Not supported.
     *
     * @param step
     *
     * @throws NoSuchElementException
     */
    @Override
    public void add(Step step) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
