package racing

import RacingGame
import racing.ui.InputView

fun main() {
    val cars = InputView.getCars()
    val movingCount = InputView.getMoveCount()

    val racingGame = RacingGame(cars, RacingMovingRule(movingCount))
    racingGame.goRacing()
}
