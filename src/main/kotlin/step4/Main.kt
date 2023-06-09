package step4

private const val DRIVER_NAME_DELIMITER = ","

fun main() {
    val carNames = InputView.getCarNames().split(DRIVER_NAME_DELIMITER)
    val tryNum = InputView.getTryNum()

    val records = GameRecords(getInitRecord(carNames))

    ResultView.startPrintGame()
    for (i in 0 until tryNum) {
        val gameResult = RacingGame.play(records)
        ResultView.printGameResult(gameResult)
    }
}

private fun getInitRecord(carNames: List<String>): Map<CarName, Score> {
    return carNames.associate { CarName(it) to Score() }
}

