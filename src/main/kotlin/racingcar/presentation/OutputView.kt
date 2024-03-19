package racingcar.presentation

import racingcar.domain.CarDto

object OutputView {
    const val DISTANCE_VIEW = "-"

    fun printResultOfRacing(cars: List<CarDto>) {
        for (car in cars) {
            println("[name: ${car.name}] ${toDisplayPosition(car.position)}")
        }
        println("######################")
    }

    private fun toDisplayPosition(position: Int): String {
        val stringBuilder = StringBuilder()

        for (i in 1..position) {
            stringBuilder.append(DISTANCE_VIEW)
        }

        return stringBuilder.toString()
    }
}
