package racingcar.view

import racingcar.domain.Car

object ResultView {

    private const val LOOP_START_NUMBER = 0

    fun carPositionPrints(car: List<Car>) {
        car.forEach {
            carPositionPrint(it)
        }
    }

    private fun carPositionPrint(car: Car) {
        (LOOP_START_NUMBER..car.carPosition()).forEach { _ ->
            print("-")
        }
        println()
    }
}
