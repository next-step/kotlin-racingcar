package racingcar.service

import racingcar.domain.RacingCar

object RacingCarService {

    fun race(cars: List<RacingCar>): List<RacingCar> {
        return cars.map { it.carProgress() }
    }
}
