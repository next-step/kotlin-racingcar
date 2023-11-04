package racingcar.view

import racingcar.component.Cars
import racingcar.model.Car

object RacingcarGameResultView {
    private const val CAR_DISTANCE_CHARACTER = "-"
    private const val WINNER_DISPLAY_SEPARATOR = ", "

    fun printGameStart() {
        println("실행 결과")
    }

    fun printCarsDistance(cars: Cars) {
        cars
            .getCars()
            .forEach { printCarDistance(it) }
        println()
    }

    private fun printCarDistance(car: Car) {
        val distance = car.getDistance() + 1

        println("${car.name} : " + CAR_DISTANCE_CHARACTER.repeat(distance))
    }

    fun printGameWinners(cars: List<Car>) {
        val winnersNameString = cars.joinToString(WINNER_DISPLAY_SEPARATOR) { it.name }

        println("${winnersNameString}가 최종 우승했습니다.\n")
    }
}
