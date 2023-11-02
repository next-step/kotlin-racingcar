package racingcar.view

import racingcar.model.Car

object RacingcarGameResultView {
    fun printGameStart() {
        println("실행 결과")
    }

    fun printCarsDistance(cars: List<Car>) {
        cars.forEach { printCarDistance(it) }
        println()
    }

    private fun printCarDistance(car: Car) {
        val distance = car.getDistance() + 1

        println("${car.name} : " + "-".repeat(distance))
    }

    fun printGameWinners(cars: List<Car>) {
        val winnersNameString = cars.joinToString(", ") { it.name }

        println("${winnersNameString}가 최종 우승했습니다.\n")
    }
}
