package controller

import domain.Car
import domain.Engine

class RacingGame(
    val cars: List<Car>
) {

    fun start() {
        cars.forEach {
            it.move()
        }
    }

    companion object {
        fun create(carNames: String, engine: Engine): RacingGame {
            val cars = carNames.split(",").map {
                Car(it, engine)
            }
            return RacingGame(cars)
        }
    }
}
