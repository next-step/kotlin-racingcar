package com.nextstep.racingcar.domain.rules

import com.nextstep.racingcar.domain.Movement

private const val MOVE_CONDITION = 4

class NumberMoveRule(private val generator: NumberGenerator) : MoveRule {

    override fun move(): Movement {
        val number = generator.generate()
        require(number in 0..9) { "Number should be greater than or equal 0 and less than or equal 9" }
        return if (number >= MOVE_CONDITION) Movement.MOVE else Movement.NONE
    }
}
