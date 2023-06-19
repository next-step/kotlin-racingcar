package racingcar.domain.racing

import racingcar.domain.car.carengine.CarEngine

data class RacingCondition(
    val tryCount: Int,
    val carEngine: CarEngine
)
