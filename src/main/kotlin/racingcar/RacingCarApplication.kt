package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.RacingGame
import racingcar.domain.Winner
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.inputCarNames()
    val countOfTry = InputView.inputCountOfTry()

    val racingCarController = RacingCarController(countOfTry, RacingGame.of(carNames))
    val allRacingSituations = racingCarController.start()
    val winners = racingCarController.evaluate(Winner(allRacingSituations.last()))

    ResultView.printInit()
    ResultView.printAllRacingSituations(allRacingSituations)
    ResultView.printWinners(winners)
}
