package racingcar.domain

import racingcar.domain.strategy.MOVING_CRITERIA
import racingcar.domain.strategy.TestMovingStrategy

object SimpleRacingFixture {
    val MOVING_CAR = SimpleRacingCar(TestMovingStrategy(MOVING_CRITERIA))
    val STATIC_CAR = SimpleRacingCar(TestMovingStrategy(MOVING_CRITERIA - 1))
}
