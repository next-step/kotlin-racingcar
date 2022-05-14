package racingcar.domain

class RacingCarGame(private val trialCount: Int, private val seedMaker: SeedMaker = SeedMakerImpl(), carNameList: List<String>) {
    private val carList = List(carNameList.size) { Car(carNameList[it], seedMaker) }

    private val gameResults = GameResults()

    fun play(): Unit = repeat(trialCount) {
        proceed()
        record()
    }

    fun getWinnerResult(): List<String> = gameResults.getWinnerResult(carList)

    fun getGameHistory(): List<List<CarResult>> = gameResults.gameHistory

    private fun record() {
        gameResults.record(carList)
    }

    private fun proceed(): Unit = carList.forEach { it.proceed() }
}
