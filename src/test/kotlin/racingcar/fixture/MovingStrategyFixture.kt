package racingcar.fixture

import racingcar.domain.strategy.MOVE_CONSTRAINTS
import racingcar.domain.strategy.MockRandomMovingStrategy

class MovingStrategyFixture {

    companion object {
        val MOVABLE_RANDOM_MOVE_STRATEGY = MockRandomMovingStrategy(MOVE_CONSTRAINTS)
        val IMMOVABLE_RANDOM_MOVE_STRATEGY = MockRandomMovingStrategy(MOVE_CONSTRAINTS - 1)
    }
}
