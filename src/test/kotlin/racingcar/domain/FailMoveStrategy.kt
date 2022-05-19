package racingcar.domain

import racingcar.domain.MoveStrategy

class FailMoveStrategy : MoveStrategy {
    override fun isMove() = false
}
