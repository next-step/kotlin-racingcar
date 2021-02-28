package study.step3

fun main() {
    val carCount = InputView.inputCarCount()
    val tryCount = InputView.inputTryCount()

    val resultView = ResultView()
    resultView.outputResultString()

    val racingGame = RacingGame()
    racingGame.readyGame(carCount)

    for (i in 0 until tryCount) {
        resultView.outputResult(racingGame.raceCars())
    }
}
