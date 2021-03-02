package step3

class RacingGame(private val cars: List<Car>, private val rule: Rule) {

    fun play(raceCount: Int): List<Result> {
        val results = mutableListOf<Result>()

        repeat(raceCount) {
            race()
            results.add(Result(cars))
        }

        return results
    }

    private fun race() {
        cars.filter {
            rule.isSatisfied()
        }.forEach {
            it.move()
        }
    }
}
