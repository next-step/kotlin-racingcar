package racingcar.service

import racingcar.domain.RacingCars
import racingcar.domain.toRacingCars
import kotlin.random.Random

object RacingCarService {

    private const val RANDOM_MAX_NUMBER = 10

    fun race(
        cars: RacingCars,
        randomNumber: () -> Int = { Random.nextInt(RANDOM_MAX_NUMBER) }
    ): RacingCars {
        return cars.list.map { it.carProgress(randomNumber) }.toRacingCars()
    }
}
