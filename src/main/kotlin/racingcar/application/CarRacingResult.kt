package racingcar.application

import racingcar.domain.carRacing.Car
import racingcar.domain.carRacing.TurnRecord

class CarRacingResult(
    val winners: List<Car>,
    val records: List<TurnRecord>
)
