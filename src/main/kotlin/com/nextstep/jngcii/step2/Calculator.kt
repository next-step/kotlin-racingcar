package com.nextstep.jngcii.step2

class Calculator {

    fun compute(lhs: POperator, rhs: POperator, op: Operator): POperator {
        val value = when (op) {
            Operator.PLUS -> lhs.value + rhs.value
            Operator.MINUS -> lhs.value - rhs.value
            Operator.MULTIPLY -> lhs.value * rhs.value
            Operator.DIVIDE -> lhs.value / rhs.value
        }
        val isEnd = lhs.isEnd || rhs.isEnd

        return POperator(value, isEnd)
    }
}
