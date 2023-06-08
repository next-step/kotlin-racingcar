package race

fun main() {
    CarRaceResultView().printRaceResult(
        CarRaceGame().runCarRace(
            CarRaceInputView().getStartInformation()
        )
    )
}
