/**
 * Copyright (c) 2017 Travis Anthony Torres
 */

package com.travistorres.bakery.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.travistorres.bakery.interfaces.RecipeMasterDetailFlowInterface;
import com.travistorres.bakery.R;

/**
 * RecipeMasterDetailFlowFragment
 *
 * Specifies a base class which will require the Activity Context that instantiated the Fragment
 * to implement the interface <em>RecipeMasterDetailFlowInterface</em>.  This requirement will
 * enable the Activity to control how data is provided to the child Fragment.
 *
 * @author Travis Anthony Torres
 * @version August 20, 2017
 */

public class RecipeMasterDetailFlowFragment extends Fragment {
    protected RecipeMasterDetailFlowInterface masterDetailFlowInterface;

    /**
     * Requires that the base Context implement the interface
     * <em>RecipeMasterDetailFlowInterface</em> to allow for the proper flow of data into the
     * Fragment.
     *
     * @param context
     */
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
