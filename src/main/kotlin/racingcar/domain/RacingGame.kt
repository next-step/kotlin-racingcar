package racingcar.domain

private const val MIN_CARS_SIZE = 2

class RacingGame(
    private var cars: List<Car>,
    private val tryNumber: TryNumber,
) {
    init {
        require(cars.size >= MIN_CARS_SIZE)
    }

    fun play(movementStrategy: () -> Int): List<List<Car>> {
        val result = mutableListOf<List<Car>>()
        while (!tryNumber.isComplete()) {
            cars = cars.map { it.moveOrNot(movementStrategy.invoke()) }
                .also { result.add(it) }
            tryNumber.consume()
        }

        return result.toList()
    }
}
