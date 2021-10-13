package calculator.domain

import calculator.domain.operator.Operator
import calculator.domain.operator.Operators

class MultiplicationCalculator : Calculator {
    override val operator: Operator = Operators.MULTIPLICATION

    override fun calculate(first: Int, second: Int): Int = first.times(second)
}
