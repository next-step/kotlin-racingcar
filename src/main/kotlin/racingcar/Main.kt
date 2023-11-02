package racingcar

fun main() {
    val names = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()
    val racingGame = RacingGame(createRandomGenerator(), names)
    val gameResults = racingGame.start(tryCount)
    ResultView.printGameResults(gameResults)
}

private fun createRandomGenerator(): RandomGenerator {
    return RandomGenerator { (0..9).random() }
}
