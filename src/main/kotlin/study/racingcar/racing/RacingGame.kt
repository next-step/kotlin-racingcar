package study.racingcar.racing

import study.racingcar.car.Car
import study.racingcar.generator.Generator

class RacingGame(private val cars: List<Car>, private val round: Int) {
    fun run(generator: Generator): RacingResult {
        val racing = Racing(cars, generator)
        val roundList = List(round) {
            racing.round()
        }

        return RacingResult(roundList)
    }
}
