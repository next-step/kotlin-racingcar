package study.step3.racing

import study.step3.car.CarFactory
import study.step3.generator.Generator

class RacingGame(private val countOfCars: Int, private val countOfAttempts: Int) {
    fun run(generator: Generator): List<List<Int>> {
        val racing = Racing(CarFactory.createCars(countOfCars), generator)

        return List(countOfAttempts) {
            racing.attempt()
        }
    }
}
