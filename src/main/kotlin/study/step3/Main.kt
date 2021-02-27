package study.step3

fun main() {
    val inputView = InputView()
    val carCount = inputView.inputCarCount()
    val tryCount = inputView.inputTryCount()

    val resultView = ResultView()
    resultView.outputResultString()

    val racingGame = RacingGame()
    racingGame.readyGame(carCount)

    for (i in 0 until tryCount) {
        resultView.outputResult(racingGame.raceCars())
    }
}
