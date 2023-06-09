package race

fun main() {
    CarRaceResultView().printRaceResult(
        CarRaceGame(RandomUtilImpl).runCarRace(
            CarRaceInputView().getStartInformation()
        )
    )
}
