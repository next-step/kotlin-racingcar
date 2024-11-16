package racingcar

fun main() {
    val inputView = InputView()
    val inputCarNames = inputView.inputCarSize()
    val inputRoundCount = inputView.inputRoundCount()

    val game = RacingGame(inputCarNames, inputRoundCount, RandomNumberGenerator())

    val resultView = ResultView()
    resultView.printResultMessage()
    while (!game.isEnd()) {
        game.play()
        resultView.printCurrentSituation(game.extractCarNames(), game.extractNowCarPositions())
    }

    resultView.printWinner(game.extractWinner())
}
