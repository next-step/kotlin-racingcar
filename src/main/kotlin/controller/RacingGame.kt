package controller

import domain.Car

class RacingGame(
    val cars: List<Car>
) {

    fun start() {
        cars.forEach {
            it.move()
        }
    }

    companion object {
        fun create(carNames: String): RacingGame {
            val cars = carNames.split(",").map {
                Car(it)
            }
            return RacingGame(cars)
        }
    }
}
