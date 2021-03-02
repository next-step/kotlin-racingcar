package step3

class RacingGame(private val cars: Cars, private val rule: Rule) {

    fun play(lapCount: Int): List<LapResult> {
        val lapResults = mutableListOf<LapResult>()

        repeat(lapCount) {
            race()
            lapResults.add(LapResult(cars))
        }

        return lapResults
    }

    private fun race() {
        cars.cars.filter {
            rule.isSatisfied()
        }.forEach {
            it.move()
        }
    }
}
