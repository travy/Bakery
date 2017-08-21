package com.travistorres.bakery.utils;

import com.travistorres.bakery.models.Step;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class RecipeStepsIterator implements ListIterator<Step> {
    private int index;
    private Step[] list;

    public RecipeStepsIterator(Step[] stepList) {
        index = 0;
        list = stepList;
    }

    public Step getCurrent() {
        return list[index];
    }

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

    @Override
    public boolean hasNext() {
        return index < list.length - 1;
    }

    @Override
    public Step next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return list[++index];
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public Step previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }

        return list[--index];
    }

    @Override
    public int nextIndex() {
        return index + 1;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(Step step) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Step step) {
        throw new UnsupportedOperationException();
    }
}
