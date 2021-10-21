package racingcar.fixture

import racingcar.domain.RacingCar

class RacingCarFixture {

    companion object {
        val MOVABLE_RACING_CAR = RacingCar(MovingStrategyFixture.MOVABLE_RANDOM_MOVE_STRATEGY)
        val IMMOVABLE_RACING_CAR = RacingCar(MovingStrategyFixture.IMMOVABLE_RANDOM_MOVE_STRATEGY)
    }
}
