package step3_racing_car.game.ui

import step3_racing_car.game.Car

object Screen {
    fun show(cars: List<Car>) {
        for (car in cars) {
            println("-".repeat(car.position))
        }
    }
}
