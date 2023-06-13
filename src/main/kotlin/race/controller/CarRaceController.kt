package race.controller

import race.domain.CarRaceGame
import race.domain.RandomSingleDigitGenerator
import race.view.CarRaceInputView
import race.view.CarRaceResultView

fun main() {
    CarRaceResultView().printRaceResult(
        CarRaceGame(RandomSingleDigitGenerator).runCarRace(
            CarRaceInputView().getStartInformation()
        )
    )
}
