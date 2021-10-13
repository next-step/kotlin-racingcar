package calculator

import calculator.operator.Operator
import calculator.operator.Operators

class SubtractionCalculator : Calculator {
    override val operator: Operator = Operators.SUBTRACTION

    override fun calculate(first: Int, second: Int): Int = first.minus(second)
}
