package step3

import step3.ui.InputView
import step3.ui.ResultView

fun main () {
    val carNames = InputView().askCarNames()
    val movCount = InputView().askMoveCount()
    val carRacing = CarRacing.of(carNames, movCount)
    carRacing.run(MovingStrategyRandom())
    ResultView().showResult(carRacing.cars, movCount)
}
