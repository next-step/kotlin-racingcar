package racingcar.domain

class Race(private val cars: List<Car>) {
    constructor(carCount: Int) : this(List(carCount) { Car() })

    fun run() {
        cars.forEach { it.move() }
    }

    val allMovingDistance
        get() = this.cars.map { it.position }

    val carsSize
        get() = this.cars.size
}
