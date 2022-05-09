package study

import Expression
import Operator

open class Calculator(inputString: String) {

    var expression: Expression

    init {
        expression = Expression(inputString.split(" "))
    }

    fun result(): Int {
        return calculate(expression.digits.first().toInt(), expression.operators, expression.digits.drop(1))
    }

    private fun calculate(value: Int, operators: List<String>, digits: List<String>): Int {
        return if (digits.isEmpty()) {
            value
        } else {
            val digit = digits.first().toInt()
            val operator = operators.first()

            val appliedValue = Operator.of(operator).apply(value, digit)
            calculate(appliedValue, operators.drop(1), digits.drop(1))
        }
    }
}
