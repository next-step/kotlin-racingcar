package racingcar.domain

class Cars(cars: List<Car> = emptyList()) {

    private val cars: List<Car> = cars.toList()

    val names: List<CarName> get() = cars.map { it.carName }

    fun move() {
        cars.forEach { it.move() }
    }

    fun getWinners(): Cars {
        val maxPosition = getMaxPosition()
        return Cars(cars.filter { it.getPosition() == maxPosition })
    }

    private fun getMaxPosition(): Int {
        return cars.maxOfOrNull { it.getPosition() } ?: 0
    }

    fun forEach(function: (Car) -> Unit) = cars.forEach(function)

}
