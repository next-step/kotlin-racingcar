package src.racingcar2

import src.racingcar.getCarMoveRandomValue

object ResultView {
    fun printResult(tryCount: Int, carCount: Int) {
        val cars = mutableListOf<Car>()

        repeat(carCount) {
            cars.add(Car())
        }

        repeat(tryCount) {
            for (car in cars) {
                car.move(getCarMoveRandomValue())
                print("-".repeat(car.position))
            }
            println()
        }
    }
}