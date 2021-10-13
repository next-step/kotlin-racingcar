package calculator.domain

import calculator.domain.operator.Operator
import calculator.domain.operator.Operators

class SubtractionCalculator : Calculator {
    override val operator: Operator = Operators.SUBTRACTION

    override fun calculate(first: Int, second: Int): Int = first.minus(second)
}
