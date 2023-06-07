package race

fun main() {
    CarRaceResultView().printCurrentState(
        CarRaceGame().runCarRace(
            CarRaceInputView().getStartInformation()
        )
    )
}
