package racing

import racing.view.GameInputView

fun main() {
    val game = GameInputView().inputRacingGameInfo()
    println()
    game.play()
}
