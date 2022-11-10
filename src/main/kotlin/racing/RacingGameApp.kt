package racing

import racing.domain.Game
import racing.view.GameInputView

fun main() {
    val racingCarCount = GameInputView.inputRacingCarCount()
    val racingRound = GameInputView.inputRacingRound()
    println()

    Game.play(racingCarCount, racingRound)
}
