package racing

fun main() {
    val carNum = InputView.getCarNum()
    val tryNum = InputView.getTryNum()

    var records = GameRecords(IntArray(carNum) { 0 })
    ResultView.startResultOutput()

    for (i in 0 until tryNum) {
        val gameResult = RacingGame.play(carNum, records)
        ResultView.printGameResult(gameResult)
    }
}