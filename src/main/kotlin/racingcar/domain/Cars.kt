package racingcar.domain

class Cars(private val randomGenerator: RandomGenerator, names: List<String>) {
    private val cars: List<Car>
    val positions: Positions
        get() = Positions(cars.map { Position(it.name, it.position) })

    init {
        cars = names.map { Car(it) }
    }

    fun move() {
        cars.forEach { it.move(randomGenerator.generate()) }
    }
}
