package race

fun main() {
    CarRaceResultView().printRaceResult(
        CarRaceGame(RandomUtil).runCarRace(
            CarRaceInputView().getStartInformation()
        )
    )
}
