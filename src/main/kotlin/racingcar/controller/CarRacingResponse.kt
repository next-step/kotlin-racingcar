package racingcar.controller

import racingcar.domain.car.CarName
import racingcar.domain.result.CarRacingResult

class CarRacingResponse(
    val results: List<CarRacingResult>,
    val winners: List<CarName>
)
