package calculator

import calculator.operator.Operator
import calculator.operator.Operators

class AdditionCalculator : Calculator {
    override val operator: Operator = Operators.ADDITION

    override fun calculate(first: Int, second: Int): Int = first.plus(second)
}
