package racingcar

fun main() {
    val carNames: List<String> = InputView.getCarName()
    var records = RacingGame(CarFactory.manufacture(carNames))
    val tryNum = InputView.getTryNum()

    ResultView.startPrintGame()

    for (i in 0 until tryNum) {
        records.play(RandomNumStrategy())
        ResultView.printGameResult(records)
    }
    ResultView.printGameWinner(records)
}
