package calculator

import calculator.operator.Operator
import calculator.operator.Operators

class MultiplicationCalculator : Calculator {
    override val operator: Operator = Operators.MULTIPLICATION

    override fun calculate(first: Int, second: Int): Int = first.times(second)
}
