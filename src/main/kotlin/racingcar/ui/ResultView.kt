package racingcar.ui

import racingcar.model.Car

object ResultView {
    fun printRacingResult(carList: List<Car>) {
        for (car in carList) {
            println(car.distance)
        }
        println()
    }
}
