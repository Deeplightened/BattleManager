package fr.enlight.bindablecomponents.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import fr.enlight.bindablecomponents.BindableViewModel;

/**
 *
 */

public class BindingRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    public BindingRecyclerViewHolder(ViewDataBinding viewBinding) {
        super(viewBinding.getRoot());
        binding = viewBinding;
    }

    public void setViewModel(BindableViewModel viewModel) {
        binding.setVariable(viewModel.getVariableId(), viewModel);
        binding.executePendingBindings();
    }
}
