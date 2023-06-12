package race

fun main() {
    CarRaceResultView().printRaceResult(
        CarRaceGame(RandomSingleDigitGenerator).runCarRace(
            CarRaceInputView().getStartInformation()
        )
    )
}
