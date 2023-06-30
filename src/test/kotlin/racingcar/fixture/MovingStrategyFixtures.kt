package racingcar.fixture

import racingcar.domain.movingstrategy.MovingStrategy

val ALWAYS_MOVING_STRATEGY = MovingStrategy { true }

val NEVER_MOVING_STRATEGY = MovingStrategy { false }
