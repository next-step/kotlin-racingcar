package racingcar.game.ui

import racingcar.game.Car

object Screen {
    fun show(cars: List<Car>) {
        for (car in cars) {
            println("-".repeat(car.position))
        }
    }
}
