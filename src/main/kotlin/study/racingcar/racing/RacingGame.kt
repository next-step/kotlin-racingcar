package study.racingcar.racing

import study.racingcar.car.CarFactory
import study.racingcar.generator.Generator

class RacingGame(private val countOfCars: Int, private val countOfAttempts: Int) {
    fun run(generator: Generator): List<List<Int>> {
        val racing = Racing(CarFactory.createCars(countOfCars), generator)

        return List(countOfAttempts) {
            racing.attempt()
        }
    }
}
