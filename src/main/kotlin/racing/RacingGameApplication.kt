package racing

import racing.application.RacingGame
import racing.ui.InputView

fun main() {
    val carNames = InputView.getCarNames()
    val tryCount = InputView.getTryCount()

    RacingGame(tryCount = tryCount, carNames = carNames).runRace()
}
