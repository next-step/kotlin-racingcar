package calculator

import java.math.BigDecimal
import java.math.MathContext

fun String.toBigDecimal(): BigDecimal {
    return try {
        this.toBigDecimal(MathContext.DECIMAL128)
    } catch (ex: NumberFormatException) {
        throw IllegalArgumentException("Invalid operand : $this")
    }
}

class StringCalculator(
    val parser: StringCalculatorInputParser,
    val calculator: Calculator
) {

    private val operators = setOf("+", "-", "/", "*")

    fun calculate(input: String?): String {
        val expression = parser.parse(input)
        var result = expression[0].toBigDecimal()

        for (index in 1 until expression.size step(2)) {
            val expressionOperator = expression[index]
            val operand = expression[index + 1].toBigDecimal()

            result = when (expressionOperator) {
                "+" -> calculator.add(result, operand)
                "-" -> calculator.subtract(result, operand)
                "/" -> calculator.divide(result, operand)
                "*" -> calculator.multiply(result, operand)
                else -> throw IllegalArgumentException("Invalid operator : $expressionOperator")
            }
        }

        return result.toString()
    }
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
