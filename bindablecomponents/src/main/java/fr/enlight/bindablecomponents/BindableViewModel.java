package fr.enlight.bindablecomponents;

import android.support.annotation.LayoutRes;

/**
 *
 */

public interface BindableViewModel{

    @LayoutRes
    int getLayoutRes();

    int getVariableId();
}
