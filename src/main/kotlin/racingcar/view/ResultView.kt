package racingcar.view

import racingcar.domain.Car

object ResultView {

    fun carPositionPrints(car: List<Car>) {
        car.forEach {
            carPositionPrint(it)
        }
    }

    private fun carPositionPrint(car: Car) {
        println("-".repeat(car.carPosition()))
    }
}
