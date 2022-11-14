package racingcar.domain.carRacing.dto

import racingcar.domain.carRacing.Car

class CarRacingResult(
    val winners: List<Car>,
    val records: List<TurnRecord>
)
