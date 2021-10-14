package calculator.domain

import calculator.domain.operator.Operator

interface Calculator {
    val operator: Operator
    fun calculate(first: Int, second: Int): Int
}
