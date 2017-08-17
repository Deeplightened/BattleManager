package fr.enlight.bindablecomponents;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import fr.enlight.bindablecomponents.BindableViewModel;

/**
 *
 */
public class ListBindableViewModel extends BaseObservable {

    private List<BindableViewModel> viewModels;

    @Bindable
    public List<? extends BindableViewModel> getViewModels() {
        return viewModels;
    }

    public void setViewModels(List<BindableViewModel> viewModels) {
        this.viewModels = viewModels;
        notifyChange();
    }
}
