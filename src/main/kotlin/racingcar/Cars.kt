package racingcar

class Cars(
    private val randomGenerator: RandomGenerator,
    size: Int,
) {
    private val cars: List<Car>

    init {
        cars = (0 until size).map { Car() }
    }

    fun move() {
        cars.forEach { it.move(randomGenerator.generate()) }
    }

    fun list(): List<Car> {
        return cars
    }
}
