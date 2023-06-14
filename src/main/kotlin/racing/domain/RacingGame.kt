package racing.domain

import racing.CarRandomGenerator

object RacingGame {

    const val MAX_BOUND = 10

    fun raceStart(cars: List<Car>) {
        cars.forEach {
            it.moveCar(CarRandomGenerator.createRandom(MAX_BOUND))
        }
    }
}
