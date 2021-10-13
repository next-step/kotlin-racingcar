package calculator

import calculator.operator.Operator
import calculator.operator.Operators

class DivisionCalculator : Calculator {
    override val operator: Operator = Operators.DIVISION

    override fun calculate(first: Int, second: Int): Int = first.div(second)
}
