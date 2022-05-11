package racingcar.domain.collection

import racingcar.domain.Car

class Cars(
    private val cars: List<Car>
) {
    fun run() {
        cars.forEach(Car::run)
    }

    fun getPositions(): List<Int> {
        return cars.map { it.position }
    }
}
