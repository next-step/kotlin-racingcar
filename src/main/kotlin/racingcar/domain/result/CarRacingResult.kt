package racingcar.domain.result

import racingcar.domain.car.Car

class CarRacingResult(
    val cars: List<Car>,
) {
    fun getFarthestCar(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.position == maxPosition }
    }

    private fun getMaxPosition(): Int =
        cars.maxOf { it.position }
}
