package domain

import util.Engine

class RacingGame(
    val cars: List<Car>
) {

    fun start(): List<Car> {
        cars.forEach {
            it.move()
        }
        return cars
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
