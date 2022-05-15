package racingCar

fun main() {
    val raceGame = RaceGame(InputView(Input()), ResultView(Drawer()))

    raceGame.start()
}