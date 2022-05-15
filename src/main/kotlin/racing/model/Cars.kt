package racing.model

class Cars(
    val cars: List<Car>
) {

    fun moveForward(movingStrategy: MovingStrategy) {
        cars.forEach { it.moveForward(movingStrategy) }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position() }
        return cars.filter { it.position() == maxPosition }
    }

    companion object {
        fun of(names: List<String>): Cars {
            val cars = names.map { Car.of(it) }
            return Cars(cars)
        }
    }
}
