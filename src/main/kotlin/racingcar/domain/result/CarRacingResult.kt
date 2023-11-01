package racingcar.domain.result

import racingcar.domain.car.CapturedCar

class CarRacingResult(
    val cars: List<CapturedCar>,
) {
    fun getFarthestCar(): List<CapturedCar> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.position == maxPosition }
    }

    private fun getMaxPosition(): Int =
        cars.maxOf { it.position }
}
