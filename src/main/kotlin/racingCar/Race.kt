package racingCar

class Race(private val carCount: Int) {
    private val cars: List<Car> = (1..this.carCount).map { Car() }

    val result
        get() = cars.map { it.position }

    fun run() {
        cars.forEach {
            it.move((0..9).random())
        }
    }
}
