package racingcar

class RacingGame(
    randomGenerator: RandomGenerator,
    names: List<String>,
) {
    private val cars: Cars

    init {
        cars = Cars(randomGenerator, names)
    }

    fun start(tryCount: Int): GameResults {
        val positions = mutableListOf<Positions>()
        repeat(tryCount) {
            cars.move()
            positions.add(cars.positions)
        }
        return GameResults(positions)
    }
}
