package racingcar

const val RANDOM_FROM = 0
const val RANDOM_UNTIL = 10

fun main() {
    val carNames = InputView.getCarNames()
    val gameCount = InputView.getGameCount()
    val carGame = CarGame(carNames, gameCount, RandomNumberGenerator(RANDOM_FROM, RANDOM_UNTIL))

    ResultView.printResultTitle()
    val gameResult = carGame.startRace()
    ResultView.printRaceResult(gameCount, gameResult)
}
