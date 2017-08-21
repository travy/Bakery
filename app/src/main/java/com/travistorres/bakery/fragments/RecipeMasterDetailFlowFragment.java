package com.travistorres.bakery.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.travistorres.bakery.R;
import com.travistorres.bakery.interfaces.RecipeMasterDetailFlowInterface;

public class RecipeMasterDetailFlowFragment extends Fragment {
    protected RecipeMasterDetailFlowInterface masterDetailFlowInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof RecipeMasterDetailFlowInterface) {
            masterDetailFlowInterface = (RecipeMasterDetailFlowInterface) context;
        } else {
            String contextClassName = context.getClass().getName();
            String masterDetailClassName = RecipeMasterDetailFlowInterface.class.getName();
            String messageFormat = context.getString(R.string.exception_non_recipe_master_detail_flow_class);
            String message = String.format(messageFormat, contextClassName, masterDetailClassName);

            throw new ClassCastException(message);
        }
    }
}
