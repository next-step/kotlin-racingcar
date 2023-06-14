package racing

fun main() {
    val carNum = InputView.getCarNum()
    val tryNum = InputView.getTryNum()

    val records = GameRecords(IntArray(carNum) { 0 })

    ResultView.startPrintGame()
    for (i in 0 until tryNum) {
        val gameResult = RacingGame.play(carNum, records)
        ResultView.printGameResult(gameResult)
    }
}
