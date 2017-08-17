package fr.enlight.battlemanager

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import fr.enlight.battlemanager.databinding.ActivityBattleMapBinding
import fr.enlight.bindablecomponents.ListBindableViewModel
import fr.enlight.bindablecomponents.recyclerview.BindingRecyclerAdapter

class BattleMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBattleMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_battle_map)


        val playersModel = ListBindableViewModel()
        playersModel.viewModels = arrayListOf(
                CharacterAvatarViewModel(R.drawable.card_icon_book_dream),
                CharacterAvatarViewModel(R.drawable.card_icon_book_earth),
                CharacterAvatarViewModel(R.drawable.card_icon_book_water),
                CharacterAvatarViewModel(R.drawable.card_icon_book_essence),
                CharacterAvatarViewModel(R.drawable.card_icon_book_illusion)
        )

        val enemiesModel = ListBindableViewModel()
        enemiesModel.viewModels = arrayListOf(
                CharacterAvatarViewModel(R.drawable.card_icon_book_blood),
                CharacterAvatarViewModel(R.drawable.card_icon_book_chaos),
                CharacterAvatarViewModel(R.drawable.card_icon_book_fire),
                CharacterAvatarViewModel(R.drawable.card_icon_book_darkness),
                CharacterAvatarViewModel(R.drawable.card_icon_book_death)
        )

        binding.playersModel = playersModel
        binding.enemiesModel = enemiesModel
    }
}
