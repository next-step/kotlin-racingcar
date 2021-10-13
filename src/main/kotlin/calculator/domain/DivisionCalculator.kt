package calculator.domain

import calculator.domain.operator.Operator
import calculator.domain.operator.Operators

class DivisionCalculator : Calculator {
    override val operator: Operator = Operators.DIVISION

    override fun calculate(first: Int, second: Int): Int = first.div(second)
}
