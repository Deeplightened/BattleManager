package fr.enlight.battlemanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import fr.enlight.bindablerecyclerview.BindingRecyclerAdapter

class BattleMapActivity : AppCompatActivity() {

    private lateinit var mPlayerRecyclerView: RecyclerView
    private lateinit var mEnemiesRecyclerView: RecyclerView

    private val mPlayerAdapter = BindingRecyclerAdapter()
    private val mEnemiesAdapter = BindingRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_map)

        mPlayerRecyclerView = findViewById(R.id.players_recycler_view)
        mEnemiesRecyclerView = findViewById(R.id.enemies_recycler_view)

        val enemiesViewModels = arrayListOf(
                CharacterAvatarViewModel(R.drawable.card_icon_book_blood),
                CharacterAvatarViewModel(R.drawable.card_icon_book_chaos),
                CharacterAvatarViewModel(R.drawable.card_icon_book_fire),
                CharacterAvatarViewModel(R.drawable.card_icon_book_darkness),
                CharacterAvatarViewModel(R.drawable.card_icon_book_death),
                CharacterAvatarViewModel(R.drawable.card_icon_book_destruction)
        )

        val playersViewModels = arrayListOf(
                CharacterAvatarViewModel(R.drawable.card_icon_book_dream),
                CharacterAvatarViewModel(R.drawable.card_icon_book_earth),
                CharacterAvatarViewModel(R.drawable.card_icon_book_water),
                CharacterAvatarViewModel(R.drawable.card_icon_book_essence),
                CharacterAvatarViewModel(R.drawable.card_icon_book_illusion),
                CharacterAvatarViewModel(R.drawable.card_icon_book_light)
        )

        mPlayerAdapter.setViewModels(playersViewModels)
        mEnemiesAdapter.setViewModels(enemiesViewModels)

        mPlayerRecyclerView.layoutManager = LinearLayoutManager(this)
        mPlayerRecyclerView.adapter = mPlayerAdapter

        mEnemiesRecyclerView.layoutManager = LinearLayoutManager(this)
        mEnemiesRecyclerView.adapter = mEnemiesAdapter
    }
}
