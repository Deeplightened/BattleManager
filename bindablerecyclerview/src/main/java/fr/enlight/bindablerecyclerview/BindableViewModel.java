package fr.enlight.bindablerecyclerview;

import android.support.annotation.LayoutRes;

/**
 *
 */

public interface BindableViewModel{

    @LayoutRes
    int getLayoutRes();

    int getVariableId();
}
