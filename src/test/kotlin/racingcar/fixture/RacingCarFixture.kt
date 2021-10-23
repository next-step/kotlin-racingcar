package racingcar.fixture

import racingcar.domain.Position
import racingcar.domain.RacingCar

class RacingCarFixture {

    companion object {
        val MOVABLE_RACING_CAR = RacingCar(NameFixture.VALID_NAME, MovingStrategyFixture.MOVABLE_RANDOM_MOVE_STRATEGY)
        val IMMOVABLE_RACING_CAR = RacingCar(NameFixture.VALID_NAME, MovingStrategyFixture.IMMOVABLE_RANDOM_MOVE_STRATEGY)
        val WINNER_RACING_CAR = RacingCar(NameFixture.VALID_NAME, MovingStrategyFixture.MOVABLE_RANDOM_MOVE_STRATEGY)
    }
}
