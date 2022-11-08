package racing

import racing.view.GameInputView
import racing.view.GameResultView

fun main() {
    val game = GameInputView().inputRacingGameInfo()
    println()
    GameResultView(game).startRacingGame()
}
