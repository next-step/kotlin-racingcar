package study.racingcar.racing

import study.racingcar.car.Car

class Winner(private val cars: List<Car>) {
    fun findWinners(): List<Car> {
        val maxLocation = getMaxLocation(cars)

        return cars.filter { it.currentLocation == maxLocation }
    }

    private fun getMaxLocation(cars: List<Car>): Int {
        return cars.maxOf { it.currentLocation }
    }
}
