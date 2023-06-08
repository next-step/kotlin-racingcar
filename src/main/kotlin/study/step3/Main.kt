package study.step3

import study.step3.car.DefaultCarFactory
import study.step3.race.Race
import study.step3.race.RandomMoveGenerator
import study.step3.view.InputView
import study.step3.view.ResultView

fun main() {
    val numberOfCars = InputView.readNumberOfCars()
    val numberOfAttempts = InputView.readNumberOfAttempts()
    val moveGenerator = RandomMoveGenerator()
    val carFactory = DefaultCarFactory()
    val race = Race(numberOfCars, numberOfAttempts, moveGenerator, carFactory)
    val raceResults = race.startRace()

    ResultView.printRaceResults(raceResults)
}
