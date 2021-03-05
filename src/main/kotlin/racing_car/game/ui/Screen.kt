package racing_car.game.ui

import racing_car.game.Car

object Screen {
    fun show(cars: List<Car>) {
        for (car in cars) {
            println("-".repeat(car.position))
        }
    }
}
