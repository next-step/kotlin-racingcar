package racingcar

class Cars(
    private val randomGenerator: RandomGenerator,
    private val carsListener: CarsListener,
    size: Int,
) {
    private val cars: List<Car>

    init {
        cars = List(size) { Car() }
    }

    fun move(tryCount: Int) {
        repeat(tryCount) {
            cars.forEach { it.move(randomGenerator.generate()) }
            carsListener.listen(this)
        }
    }

    fun positions(): List<Int> {
        return cars.map { it.position }
    }
}
