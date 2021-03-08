package race.ui

import race.domain.Race

fun main() {
    val carCount = InputView.inputCarCount()
    val raceCount = InputView.inputRaceCount()
    Race(carCount, raceCount).start()
}
