package fr.enlight.battlemanager

import android.databinding.BindingAdapter
import android.view.View
import android.view.ViewTreeObserver


@BindingAdapter("onComputeViewRect")
fun onComputeViewRect(view: View, onComputeViewRectListener: OnComputeViewRectListener){
    view.viewTreeObserver.addOnGlobalLayoutListener(AutoRemoveLayoutListener(view, {
        val position = IntArray(2)
        view.getLocationOnScreen(position)
        onComputeViewRectListener.onComputeViewRect(position[0], position[1], view.measuredWidth, view.measuredHeight)
    }))
}

interface OnComputeViewRectListener{
    fun onComputeViewRect(x: Int, y: Int, width: Int, height: Int)
}

class AutoRemoveLayoutListener(private val view: View, val layoutCompute: () -> Unit): ViewTreeObserver.OnGlobalLayoutListener{

    override fun onGlobalLayout() {
        layoutCompute()
        view.viewTreeObserver.removeOnGlobalLayoutListener(this)
    }
}