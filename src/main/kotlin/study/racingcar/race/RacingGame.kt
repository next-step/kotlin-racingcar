package study.racingcar.race

import study.racingcar.car.Car
import study.racingcar.car.RandomMoveGenerator
import study.racingcar.view.InputConsole
import study.racingcar.view.OutputConsole

class RacingGame(
    private val input: InputConsole,
    private val output: OutputConsole
) {

    fun start() {
        val carNames = input.getCarNames()
        val numberOfAttempts = input.getNumberOfAttempts()
        val moveGenerator = RandomMoveGenerator()

        val cars = carNames.map { Car(it, moveGenerator) }
        val race = Race(cars, numberOfAttempts)
        val raceSummary = race.startRace()

        output.printRaceResults(raceSummary.raceResults)
        output.printWinners(raceSummary.determineWinners())
    }
}
