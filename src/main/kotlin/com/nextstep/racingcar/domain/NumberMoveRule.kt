package com.nextstep.racingcar.domain

private const val MOVE_CONDITION = 4

class NumberMoveRule : MoveRule {

    override fun movable(number: Int): Movement {
        require(number in 0..9) { "Number should be greater than or equal 0 and less than or equal 9" }
        return if (number >= MOVE_CONDITION) Movement.MOVE else Movement.NONE
    }
}
