package racingcar.domain

class RacingGame(
    numberGenerator: NumberGenerator,
    names: List<String>,
) {
    private var cars: Cars

    init {
        cars = Cars.create(numberGenerator, names)
    }

    fun start(tryCount: Int): GameResults {
        val positions = mutableListOf<Positions>()
        repeat(tryCount) {
            cars = cars.move()
            positions.add(cars.positions)
        }
        return GameResults(positions)
    }
}
