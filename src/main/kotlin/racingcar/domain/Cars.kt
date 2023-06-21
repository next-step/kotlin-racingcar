package racingcar.domain

class Cars(cars: Collection<Car> = emptyList()) {

    private val cars: Collection<Car> = cars.toList()

    val names: Collection<CarName> get() = cars.map { it.carName }

    fun move() {
        cars.forEach { it.move() }
    }

    fun getPathStrings(): List<String> {
        return cars.map { "${it.carName} : ${it.getPathString()}" }
    }

    fun getWinners(): Cars {
        val maxPosition = getMaxPosition()
        return Cars(cars.filter { it.getPosition() == maxPosition })
    }

    private fun getMaxPosition(): Int {
        return cars.maxOfOrNull { it.getPosition() } ?: 0
    }
}
