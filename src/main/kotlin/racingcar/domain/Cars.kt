package racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    fun move(movingStrategy: MovingStrategy) {
        cars.forEach { it.move(movingStrategy) }
    }

    fun location(): List<Location> {
        return cars.map { it.location }
    }

    companion object {
        fun of(carCount: Int): Cars {
            return Cars((0 until carCount).map { Car() })
        }
    }
}
