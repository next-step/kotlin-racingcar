package racing.model

class Cars(
    val cars: List<Car>
) {

    fun moveForward(movingStrategy: MovingStrategy): Cars {
        val cars = cars.map { it.moveForward(movingStrategy) }
        return Cars(cars)
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position() }
        return cars.filter { it.position() == maxPosition }
    }

    companion object {
        fun from(names: List<String>): Cars {
            val cars = names.map { Car.from(it) }
            return Cars(cars)
        }
    }
}
