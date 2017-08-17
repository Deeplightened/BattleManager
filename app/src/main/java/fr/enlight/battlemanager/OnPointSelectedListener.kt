package fr.enlight.battlemanager

/**
 * Created by yhuriez on 26/07/2017.
 */
interface OnPointSelectedListener {
    fun onPointSelected(x: Int, y: Int)
    fun onPointPressed(x: Int, y: Int)
    fun onPointReleased(x: Int, y: Int)
}