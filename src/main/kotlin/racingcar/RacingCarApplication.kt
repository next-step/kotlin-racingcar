package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.domain.Winner
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.inputCarNames()
    val countOfTry = InputView.inputCountOfTry()

    val cars = carNames.map {
        Car(it)
    }

    val allRacingSituations = RacingCarController(countOfTry, RacingGame(cars)).start()

    ResultView.printInit()
    ResultView.printAllRacingSituations(allRacingSituations)
    ResultView.printWinners(Winner(allRacingSituations.last()).evaluate())
}
