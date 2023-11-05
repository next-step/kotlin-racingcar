package racingcar.model

class Cars {
    val cars: MutableList<Car> = mutableListOf()

    fun addCar(car: Car) {
        cars.add(car)
    }

    fun move() {
        cars.forEach { it.move() }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
