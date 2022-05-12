package com.nextstep.jngcii.step2

class Calculator {

    fun add(lhs: POperator, rhs: POperator): POperator {
        val value = lhs.value + rhs.value
        val isEnd = lhs.isEnd || rhs.isEnd

        return POperator(value, isEnd)
    }
}
