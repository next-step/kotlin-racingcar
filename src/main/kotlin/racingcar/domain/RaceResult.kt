package racingcar.domain

import racingcar.domain.car.Cars

@JvmInline value class Trial(val value: Int)

class RaceResult(
    val result: Map<Trial, Cars>
)
