package step4

private const val DRIVER_NAME_DELIMITER = ","

fun main() {
    val carNames: List<String> = InputView.getCarNames().split(DRIVER_NAME_DELIMITER)
    var records = GameRecords(getInitRecord(carNames))
    val tryNum = InputView.getTryNum()

    ResultView.startPrintGame()

    for (i in 0 until tryNum) {
        records = RacingGame.play(records)
        ResultView.printGameResult(records)
    }
    ResultView.printGameWinner(records)
}

private fun getInitRecord(carNames: List<String>): Map<CarName, Score> {
    return carNames.associate {
        require(it.length <= 5) { "자동차이름은 5자를 초과할 수 없습니다." }
        CarName(it) to Score()
    }
}

