package domain

import util.RandomNumber

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
        fun create(carNames: String, randomNumber: RandomNumber): RacingGame {
            val cars = carNames.split(",").map {
                Car(it, randomNumber)
            }
            return RacingGame(cars)
        }
    }
}
