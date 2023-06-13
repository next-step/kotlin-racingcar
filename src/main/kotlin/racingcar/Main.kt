package racingcar

fun main() {
    val carNames: List<String> = InputView.getCarName()
    var records = GameRecords(CarFactory.manufacture(carNames))
    val tryNum = InputView.getTryNum()

    ResultView.startPrintGame()

    for (i in 0 until tryNum) {
        records = RacingGame.play(records, RandomNumStrategy())
        ResultView.printGameResult(records)
    }
    ResultView.printGameWinner(records)
}
