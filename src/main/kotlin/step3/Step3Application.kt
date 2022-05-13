package step3

import step3.ui.InputView
import step3.ui.ResultView

fun main () {
    val carCount = InputView.askCarCount()
    val movCount = InputView.askMoveCount()
    val carRacing = CarRacing.of(carCount, movCount)
    carRacing.run(MovingStrategyRandom())
    ResultView.showResult(carRacing.cars, movCount)
}
