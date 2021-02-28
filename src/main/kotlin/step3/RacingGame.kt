package step3

class RacingGame(private val cars: List<Car>, private val rule: Rule, private val raceCount: Int) {
    fun play(): List<Result> {
        val results = buildResults()

        for (i in 0 until raceCount) {
            race()
            record(results)
        }

        return results
    }

    private fun buildResults() = cars.map { Result() }

    private fun race() {
        for (car in cars) {
            rule.makeFollow(car)
        }
    }

    private fun record(results: List<Result>) {
        for (i in results.indices) {
            results[i].record(cars[i])
        }
    }
}
