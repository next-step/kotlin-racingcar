package step3

class RacingGame(private val cars: Cars, private val rule: Rule) {

    fun play(lapCount: Int): List<Result> {
        val results = mutableListOf<Result>()

        repeat(lapCount) {
            race()
            results.add(Result(cars))
        }

        return results
    }

    private fun race() {
        cars.cars.filter {
            rule.isSatisfied()
        }.forEach {
            it.move()
        }
    }
}
