package step4_racing_car_winner.game.ui

import step4_racing_car_winner.game.Car

object Screen {
    fun show(cars: List<Car>, count: Int) {
        println("${count}회차")
        for (car in cars) {
            println("${car.name} :" + "-".repeat(car.position))
        }
    }
}
