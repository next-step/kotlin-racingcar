package race.ui

import race.domain.Car
import race.domain.Race
import kotlin.random.Random

fun main() {
    val carNames = InputView.inputCarNames()
    val raceCount = InputView.inputRaceCount()

    val race = Race(Car.create(carNames)) {
        Random.nextInt(Car.MOVE_START_RANGE, Car.MOVE_END_RANGE)
    }

    ResultView.printTitle()
    race.start(raceCount) {
        ResultView.printNow(it)
    }

    val winners = race.takeWinners()
    ResultView.printWinner(winners)
}
