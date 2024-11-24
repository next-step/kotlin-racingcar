package car.domain

class Round(
    private val cars: List<Car>
) {
    fun start(movePossibilities: MovePossibilities): RoundResult =
        cars.mapIndexedNotNull { index, car ->
            movePossibilities[index]
                ?.let { car.move(it) }
        }
            .let { RoundResult(it) }
}

class MovePossibilities(
    private val movePossibilities: List<MovePossibility>,
) {
    operator fun get(index: Int): MovePossibility? = movePossibilities.getOrNull(index)
}

data class RoundResult(
    val value: List<MovedCar>,
)