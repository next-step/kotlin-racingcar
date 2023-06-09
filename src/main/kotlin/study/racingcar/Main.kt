package study.racingcar

import study.racingcar.car.DefaultCarFactory
import study.racingcar.car.RandomMoveGenerator
import study.racingcar.race.Race
import study.racingcar.view.InputView
import study.racingcar.view.ResultView

fun main() {
    val carNames = InputView.getCarNames()
    val numberOfAttempts = InputView.getNumberOfAttempts()
    val moveGenerator = RandomMoveGenerator()
    val carFactory = DefaultCarFactory()

    val cars = carFactory.createCars(carNames, moveGenerator)
    val race = Race(cars, numberOfAttempts)

    val raceSummary = race.startRace()

    ResultView.printRaceResults(raceSummary.raceResults)
    ResultView.printWinners(raceSummary.determineWinners())
}
