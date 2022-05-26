package study.racingcar.view

import study.racingcar.domain.Car

data class CarView(
    val car: Car
) {
    fun printPosition() {
        println(POSITION_VALUE.repeat(car.position))
    }

    companion object {
        const val POSITION_VALUE: String = "-"
    }
}
