package fr.enlight.bindablecomponents.dialog;


import java.io.Serializable;

import fr.enlight.bindablecomponents.BindableViewModel;

public interface DialogViewModel extends BindableViewModel, Serializable {

    void setListener(DismissDialogListener listener);
}
