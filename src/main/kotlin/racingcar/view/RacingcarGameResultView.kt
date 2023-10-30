package racingcar.view

import racingcar.model.Car

class RacingcarGameResultView {
    fun printCarsDistance(cars: List<Car>) {
        cars.forEach { printCarDistance(it) }
        println()
    }

    private fun printCarDistance(car: Car) {
        val distance = car.currentDistance() + 1

        println("-".repeat(distance))
    }
}
