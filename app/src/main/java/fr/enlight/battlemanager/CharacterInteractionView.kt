package fr.enlight.battlemanager

import android.content.Context
import android.databinding.BindingAdapter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.util.Range
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import fr.enlight.bindablecomponents.BindableViewModel
import fr.enlight.bindablecomponents.ListBindableViewModel
import fr.enlight.bindablecomponents.utils.BindingAdapters


class CharacterInteractionView : ConstraintLayout{

    private var x1: Int = 0
    private var y1: Int = 0
    private var x2: Int = 0
    private var y2: Int = 0
    private var drawing = false
    private var paintObject = Paint()

    lateinit var playersLayout: LinearLayout
    lateinit var enemiesLayout: LinearLayout

    lateinit var playersVM: List<CharacterAvatarViewModel>
    lateinit var enemiesVM: List<CharacterAvatarViewModel>

    private val viewModelsRange = HashMap<Range<Int>, Map<Int, CharacterAvatarViewModel>>()


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        View.inflate(context, R.layout.custom_view_character_interaction, this)

        playersLayout = findViewById(R.id.players_layout)
        enemiesLayout = findViewById(R.id.enemies_layout)
    }

    fun setPlayersViewModels(viewModels: List<BindableViewModel>){
        playersVM = viewModels
                .filter { it is CharacterAvatarViewModel }
                .map { it as CharacterAvatarViewModel }

        BindingAdapters.setViewModels(playersLayout, playersVM)
    }

    fun setEnemiesViewModels(viewModels: List<BindableViewModel>){
        enemiesVM = viewModels
                .filter { it is CharacterAvatarViewModel }
                .map { it as CharacterAvatarViewModel }
        
        BindingAdapters.setViewModels(enemiesLayout, enemiesVM)
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)

        paintObject.color = Color.BLACK
        paintObject.strokeWidth = 8.0f

        if (drawing && canvas != null) {
            canvas.drawLine(x1.toFloat(), y1.toFloat(), x2.toFloat(), y2.toFloat(), paintObject)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var result = false
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                x2 = event.x.toInt()
                x1 = x2
                y2 = event.y.toInt()
                y1 = y2
                drawing = true
                result = true
            }
            MotionEvent.ACTION_MOVE -> {
                x2 = event.x.toInt()
                y2 = event.y.toInt()
                result = true
            }
            MotionEvent.ACTION_UP -> {
                x2 = event.x.toInt()
                y2 = event.y.toInt()
                drawing = false
                result = true
            }
            MotionEvent.ACTION_BUTTON_PRESS -> performClick()
        }

        if (result)
            invalidate()
        return result
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }
}

@BindingAdapter("players")
fun setPlayers(characterInteractionView: CharacterInteractionView, listBindableViewModel: ListBindableViewModel?){
    val viewModels = listBindableViewModel?.viewModels ?: return
    characterInteractionView.setPlayersViewModels(viewModels)
}

@BindingAdapter("enemies")
fun setEnemies(characterInteractionView: CharacterInteractionView, listBindableViewModel: ListBindableViewModel?){
    val viewModels = listBindableViewModel?.viewModels ?: return
    characterInteractionView.setEnemiesViewModels(viewModels)
}