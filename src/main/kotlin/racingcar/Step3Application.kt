package racingcar

import racingcar.domain.CarRacing
import racingcar.domain.MovingStrategyRandom
import racingcar.view.InputView
import racingcar.view.ResultView

fun main () {
    val inputView = InputView()
    val carNames = inputView.askCarNames()
    val movCount = inputView.askMoveCount()

    val carRacing = CarRacing.of(carNames, movCount)
    carRacing.run(MovingStrategyRandom())
    val winnerList = carRacing.cars.getWinnerList()

    val resultView = ResultView()
    resultView.showResult(carRacing.cars, movCount)
    resultView.printWinnerList(winnerList)
}
