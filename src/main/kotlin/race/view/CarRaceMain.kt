package race.view

import race.domain.CarRaceGame
import race.domain.RandomSingleDigitGenerator

fun main() {
    CarRaceResultView().printRaceResult(
        CarRaceGame(RandomSingleDigitGenerator).runCarRace(
            CarRaceInputView().getStartInformation()
        )
    )
}
