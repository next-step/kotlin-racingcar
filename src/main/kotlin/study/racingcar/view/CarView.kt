package study.racingcar.view

import study.racingcar.domain.Car

data class CarView(
    val car: Car
) {

    private val position = POSITION_VALUE.repeat(car.position)

    val result = "${car.name} : $position"

    companion object {
        const val POSITION_VALUE: String = "-"
    }
}
