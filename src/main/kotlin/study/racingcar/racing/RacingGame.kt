package study.racingcar.racing

import study.racingcar.car.Car
import study.racingcar.generator.Generator

class RacingGame(private val cars: List<Car>, private val attempts: Int) {
    fun run(generator: Generator): List<List<Result>> {
        val racing = Racing(cars, generator)

        return List(attempts) {
            racing.attempt()
        }
    }

    fun getWinner(): List<Car> {
        val max: Int = cars.map { car ->
            car.currentLocation
        }.maxOrNull() ?: 1


        return cars.filter { car -> car.currentLocation == max }
    }
}
