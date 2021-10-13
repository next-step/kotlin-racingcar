package calculator

import calculator.operator.Operator

interface Calculator {
    val operator: Operator
    fun calculate(first: Int, second: Int): Int
}
