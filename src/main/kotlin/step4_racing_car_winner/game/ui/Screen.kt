package step4_racing_car_winner.game.ui

import step4_racing_car_winner.game.Car

object Screen {
    fun show(cars: List<Car>, count: Int) {
        println("${count}회차")
        for (car in cars) {
            println("${car.name} :" + "-".repeat(car.position))
        }
    }

    fun announcement(winners: List<Car>) {
        println("${winners.joinToString(",", transform = {it.name})}가 최종 우승했습니다.")
    }
}
