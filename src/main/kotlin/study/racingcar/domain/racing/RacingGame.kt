package study.racingcar.domain.racing

import study.racingcar.domain.car.Car
import study.racingcar.domain.generator.Generator

class RacingGame(private val cars: List<Car>, private val round: Int) {
    fun run(generator: Generator): RacingResult {
        val racing = Racing(cars, generator)
        val roundList = List(round) {
            racing.round()
        }

        return RacingResult(roundList)
    }
}
