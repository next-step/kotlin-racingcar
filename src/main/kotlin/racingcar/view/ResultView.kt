package racingcar.view

import racingcar.domain.Car

object ResultView {
    fun print(cars: List<Car>) {
        for (car in cars) {
            val location = car.location
            print(car.name + " : ")
            repeat(location) { print("-") }
            println()
        }
        println()
    }
}
