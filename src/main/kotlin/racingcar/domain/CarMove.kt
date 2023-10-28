package racingcar.domain

import racingcar.util.Environment

object CarMove {

    fun canMoveForward(): Boolean = Environment.CAR_MOVE_FORWARD_CONDITION >= Environment.CAR_RACING_RANDOM_RANGE.random()
}
