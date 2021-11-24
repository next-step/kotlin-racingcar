package racingcar.dto

import racingcar.domain.cars.Car

class RacingRecord(
    car: Car,
    val name: String = car.name,
    val racingDistance: Int = car.racingDistance()
)
