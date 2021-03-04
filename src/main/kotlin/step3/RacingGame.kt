package step3

class RacingGame(private val cars: Cars, private val rule: Rule) {

    fun play(lapCount: Int): LapResults {
        val lapResults = mutableListOf<LapResult>()

        repeat(lapCount) {
            race()
            lapResults.add(LapResult(cars))
        }

        return LapResults(lapResults)
    }

    private fun race() {
        cars.filter {
            rule.isSatisfied()
        }.forEach {
            it.move()
        }
    }
}
