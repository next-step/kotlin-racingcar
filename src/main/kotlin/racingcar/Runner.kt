package racingcar

import racingcar.domain.RacingGame
import racingcar.ui.InputView

fun main(args: Array<String>) {
    val numberOfCars = InputView.getNumberOfCars()
    val tryCount = InputView.getTryCounts()

    RacingGame(tryCount = tryCount, numberOfCar = numberOfCars).runRace()
}
