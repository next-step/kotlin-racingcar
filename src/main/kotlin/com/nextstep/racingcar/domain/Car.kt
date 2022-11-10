package com.nextstep.racingcar.domain

private const val MOVE_CONDITION = 4

class Car {

    fun move(number: Int): Boolean {
        require(number in 0..9) { "Number should be greater than or equal 0 and less than or equal 9" }
        return number >= MOVE_CONDITION
    }
}
