package racingcar

class RacingCarGame(private val trialCount: Int, private val seedMaker: SeedMaker, carCount: List<String>) {
    private val carList = List(carCount.size) { Car(carCount[it], seedMaker) }

    val gameResults = GameResults()

    fun play(): Unit = repeat(trialCount) {
        proceed()
        record()
    }

    fun getWinnerResult(): List<String> = gameResults.getWinnerResult(carList)

    private fun record() {
        gameResults.record(carList)
    }

    private fun proceed(): Unit = carList.forEach { it.proceed() }
}
