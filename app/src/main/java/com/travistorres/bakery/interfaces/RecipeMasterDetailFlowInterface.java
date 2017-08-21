package com.travistorres.bakery.interfaces;

import com.travistorres.bakery.models.Recipe;
import com.travistorres.bakery.models.Step;

public interface RecipeMasterDetailFlowInterface {
    Recipe getRecipe();
    void onSelectedStep(Step step);
    void onSelectNextStep();
    void onSelectPreviousStep();
    boolean hasNextStep();
    boolean hasPreviousStep();
}
