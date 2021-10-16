package racingcar.domain

import racingcar.domain.strategy.MovingStrategy
import racingcar.domain.vo.Position

interface RacingCar {
    val movingStrategy: MovingStrategy
    val position: Position
    fun moved(): RacingCar
}
