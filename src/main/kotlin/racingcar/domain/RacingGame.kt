package racingcar.domain

class RacingGame(
    numberGenerator: NumberGenerator,
    names: List<String>,
) {
    private val cars: Cars

    init {
        cars = Cars(numberGenerator, names)
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
