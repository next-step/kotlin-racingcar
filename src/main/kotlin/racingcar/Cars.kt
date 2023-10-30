package racingcar

class Cars(private val randomGenerator: RandomGenerator, names: List<String>) {
    private val cars: List<Car>

    init {
        cars = names.map { Car(it) }
    }

    fun move() {
        cars.forEach { it.move(randomGenerator.generate()) }
    }

    fun positions(): List<Position> {
        return cars.map { Position(it.name, it.position) }
    }
}
