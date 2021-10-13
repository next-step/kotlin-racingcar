package calculator.domain

import calculator.domain.operator.Operator
import calculator.domain.operator.Operators

class AdditionCalculator : Calculator {
    override val operator: Operator = Operators.ADDITION

    override fun calculate(first: Int, second: Int): Int = first.plus(second)
}
