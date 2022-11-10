package com.nextstep.racingcar.domain

private const val MOVE_CONDITION = 4

class Car {

    fun move(numberGenerator: NumberGenerator): Movement {
        val number = numberGenerator.generate().toInt()
        require(number in 0..9) { "Number should be greater than or equal 0 and less than or equal 9" }
        return if (number >= MOVE_CONDITION) Movement.MOVE else Movement.NONE
    }
}
