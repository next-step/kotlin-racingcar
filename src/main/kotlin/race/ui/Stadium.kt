package race.ui

import race.domain.Race

fun main() {
    val carNames = InputView.inputCarNames()
    val raceCount = InputView.inputRaceCount()
    Race(carNames, raceCount)
        .start()
        .result()
}
