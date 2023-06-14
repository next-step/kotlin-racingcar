package racingcar

fun main() {
    val carNames: List<String> = InputView.getCarName()
    var game = RacingGame(CarFactory.manufacture(carNames))
    val tryNum = InputView.getTryNum()

    ResultView.startPrintGame()

    for (i in 0 until tryNum) {
        game.play(RandomNumStrategy())
        ResultView.printGameResult(game)
    }
    ResultView.printGameWinner(game.getWinners())
}
