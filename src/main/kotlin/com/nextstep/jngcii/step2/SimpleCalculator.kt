package com.nextstep.jngcii.step2

class SimpleCalculator : Calculator {

    override fun run(left: Operand, right: Operand, operator: Operator): Operand {
        val value = when (operator) {
            Operator.PLUS -> left.value + right.value
            Operator.MINUS -> left.value - right.value
            Operator.MULTIPLY -> left.value * right.value
            Operator.DIVIDE -> left.value / right.value
        }
        val isEnd = left.isEnd || right.isEnd

        return Operand(value, isEnd)
    }
}
