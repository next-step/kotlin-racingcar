package study

import Expression

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

            calculate(apply(value, digit, operator), operators.drop(1), digits.drop(1))
        }
    }

    private fun apply(digit1: Int, digit2: Int, operator: String): Int {
        return when (operator) {
            "+" -> plus(digit1, digit2)
            "-" -> substract(digit1, digit2)
            "*" -> multiply(digit1, digit2)
            "/" -> divide(digit1, digit2)
            else -> 0
        }
    }

    companion object {
        val plus = { x: Int, y: Int -> x + y }
        val substract = { x: Int, y: Int -> x - y }
        val multiply = { x: Int, y: Int -> x * y }
        val divide = { x: Int, y: Int -> x / y }
    }
}
