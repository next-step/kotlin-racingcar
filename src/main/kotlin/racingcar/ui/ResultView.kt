package racingcar.ui

import racingcar.car.Car

object ResultView {
    fun drawHistory(tryNumber: Int, cars: MutableList<Car>) {
        repeat(tryNumber) { stage ->
            drawCarsMovements(cars, stage)
        }
    }

    private fun drawCarsMovements(cars: MutableList<Car>, index: Int) {
        cars.forEach { car ->
            drawMovements(car.moveHistory, index)
        }
        println()
    }

    private fun drawMovements(moveHistory: Car.MoveHistory, index: Int) {
        repeat(moveHistory.movements.get(index)) {
            print("-")
        }
        println()
    }
}
