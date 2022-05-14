package racingcar

class RacingCarGame(private val trialCount: Int, private val seedMaker: SeedMaker, carCount: List<String>) {
    private val carList = List(carCount.size) { Car(carCount[it], seedMaker) }

    val gameResults = GameResults()

    fun play() = repeat(trialCount) {
        proceed()
        record()
    }

    fun getWinnerResult() = gameResults.getWinnerResult(carList)

    private fun record() {
        gameResults.record(carList)
    }

    private fun proceed() = carList.forEach { it.proceed() }
}
