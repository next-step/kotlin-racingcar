package racingcar.dto

import racingcar.domain.cars.RacingCar

class RacingRecord(
    racingCar: RacingCar,
    val name: String = racingCar.name,
    val racingDistance: Int = racingCar.racingDistance()
)
