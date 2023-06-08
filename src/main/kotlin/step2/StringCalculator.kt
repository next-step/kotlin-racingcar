package step2

import java.math.BigDecimal

class StringCalculator(
    val parser: StringCalculatorInputParser,
    val calculator: Calculator
) {

    private val operators = setOf("+", "-", "/", "*")

    fun calculate(input: String?): String {
        val expression = parser.parse(input)
        var result = BigDecimal(expression[0])
        var expressionOperator = ""

        for (index in 1 until expression.size) {
            if (isOperator(expression[index])) {
                expressionOperator = expression[index]
            }

            if (!isOperator(expression[index])) {
                val operand = BigDecimal(expression[index])
                result = when (expressionOperator) {
                    "+" -> calculator.add(result, operand)
                    "-" -> calculator.subtract(result, operand)
                    "/" -> calculator.divide(result, operand)
                    "*" -> calculator.multiply(result, operand)
                    else -> throw IllegalArgumentException("Invalid operator : $expressionOperator")
                }
            }
        }

        return result.toString()
    }

    private fun isOperator(input: String): Boolean = operators.contains(input)
}

fun main() {
    val input = readlnOrNull()

    val calculator = StringCalculator(
        parser = StringCalculatorInputParser(),
        calculator = Calculator()
    )

    val result = calculator.calculate(input)

    println(result)
}
