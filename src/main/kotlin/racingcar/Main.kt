package racingcar

fun main() {
    val carNum = InputView.getCarNum()
    val tryNum = InputView.getTryNum()

    var records = GameRecords(CarFactory.manufacture(carNum))

    ResultView.startPrintGame()

    for (i in 0 until tryNum) {
        records = RacingGame.play(carNum, records, RandomNumStrategy())
        ResultView.printGameResult(records)
    }
}
