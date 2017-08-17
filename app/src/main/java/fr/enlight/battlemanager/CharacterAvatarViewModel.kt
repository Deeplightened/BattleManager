package fr.enlight.battlemanager

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.res.ResourcesCompat
import fr.enlight.bindablecomponents.BindableViewModel


class CharacterAvatarViewModel(@DrawableRes private val avatarRes: Int): BindableViewModel {

    override fun getLayoutRes(): Int {
        return R.layout.item_character_avatar
    }

    override fun getVariableId(): Int {
        return BR.model
    }

    fun getAvatar(context: Context): Drawable? {
        return ResourcesCompat.getDrawable(context.resources, avatarRes, null)
    }
}