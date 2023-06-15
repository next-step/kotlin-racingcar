package racinggame.view

import racinggame.domain.car.CarName

data class RacingGameInput(
    val carNames: List<CarName>,
    val gamePlayCount: Int,
)
