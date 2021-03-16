package racingcar

import racingcar.domain.RacingGame
import racingcar.ui.InputView
import racingcar.ui.OutputView

fun main(args: Array<String>) {
    val numberOfCars = InputView.getNumberOfCars()
    val tryCount = InputView.getTryCounts()

    val racingGame = RacingGame(tryCount = tryCount, numberOfCar = numberOfCars)
    val raceHistory = racingGame.runRace()

    OutputView.printOutputLetter()
    OutputView.printRacingGame(raceHistory)
}
