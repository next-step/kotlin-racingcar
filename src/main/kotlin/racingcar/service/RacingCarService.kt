package racingcar.service

import racingcar.domain.RacingCars
import racingcar.domain.RandomNumberGenerator
import racingcar.domain.toRacingCars

object RacingCarService {

    fun race(
        cars: RacingCars,
    ): RacingCars {
        return cars.map { it.carProgress(RandomNumberGenerator.generate()) }.toRacingCars()
    }
}
