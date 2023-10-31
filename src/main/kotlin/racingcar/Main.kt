package racingcar

fun main() {
    val names = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()
    val racingGame = RacingGame(ResultView, createRandomGenerator(), names)

    racingGame.start(tryCount)
}

private fun createRandomGenerator(): RandomGenerator {
    return RandomGenerator { (0..9).random() }
}
