package study.racingcar

fun main() {
    val carCount = InputView.inputCarCount()
    val tryCount = InputView.inputTryCount()

    ResultView.outputResultString()

    val racingGame = RacingGame(MoveCarStrategy())
    racingGame.readyGame(carCount)

    for (i in 0 until tryCount) {
        ResultView.outputResult(racingGame.raceCars())
    }
}
