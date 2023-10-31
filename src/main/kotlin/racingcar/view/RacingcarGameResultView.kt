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

        println("-".repeat(distance))
    }
}
