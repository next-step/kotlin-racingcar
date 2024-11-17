package racingcar

const val RANDOM_FROM = 0
const val RANDOM_UNTIL = 10

fun main() {
    val carCount = InputView.getCarCount()
    val gameCount = InputView.getGameCount()
    val carGame = CarGame(carCount, gameCount, RandomNumberGenerator(RANDOM_FROM, RANDOM_UNTIL))

    ResultView.printResultTitle()
    while (carGame.isPlaying()) {
        carGame.playSinglePhase()
        ResultView.printRaceResult(carGame.cars)
    }
}
