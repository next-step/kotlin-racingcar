package racinggame.domain.field

import racinggame.domain.car.RacingCar

data class Field(
    val racingCar: RacingCar,
    val moveDistance: MoveDistance,
)
