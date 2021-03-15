package race.ui

import race.domain.Car
import race.domain.Race
import kotlin.random.Random

fun main() {
    val carNames = InputView.inputCarNames()
    val raceCount = InputView.inputRaceCount()

    val winners = Race(Car.create(carNames))
        .start(raceCount) { Random.nextInt(Car.MOVE_START_RANGE, Car.MOVE_END_RANGE) }
        .takeWinners()
    ResultView.printWinner(winners)
}
