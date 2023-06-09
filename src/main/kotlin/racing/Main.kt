package racing

fun main() {
    val carNum = InputView.getCarNum()
    val tryNum = InputView.getTryNum()

    var records = GameRecords(IntArray(carNum) { 0 })

    ResultView.startPrintGame()

    for (i in 0 until tryNum) {
        records = RacingGame.play(carNum, records)
        ResultView.printGameResult(records)
    }
}
