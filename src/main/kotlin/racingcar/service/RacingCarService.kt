package racingcar.service

import racingcar.domain.RacingCar
import kotlin.random.Random

object RacingCarService {

    private const val RANDOM_MAX_NUMBER = 10

    fun race(
        cars: List<RacingCar>,
        randomNumber: () -> Int = { Random.nextInt(RANDOM_MAX_NUMBER) }
    ): List<RacingCar> {
        return cars.map { it.carProgress(randomNumber) }
    }
}
