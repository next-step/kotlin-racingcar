package racingcar.view

import racingcar.car.Car

object ResultView {

    fun printCarPositions(cars: List<Car>) {
        cars.forEach { car ->
            println(car)
        }
        println()
    }
}
