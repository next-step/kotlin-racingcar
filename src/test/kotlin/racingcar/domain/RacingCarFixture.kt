package racingcar.domain

import racingcar.domain.strategy.MOVING_CRITERIA
import racingcar.domain.strategy.TestMovingStrategy

object RacingCarFixture {
    val MOVING_CAR = RacingCar(TestMovingStrategy(MOVING_CRITERIA))
    val STATIC_CAR = RacingCar(TestMovingStrategy(MOVING_CRITERIA - 1))
}
