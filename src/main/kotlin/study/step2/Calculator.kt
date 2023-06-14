package study.step2

import study.step2.equation.Equation
import study.step2.equation.Equation.Operator

object Calculator {

    fun calculate(input: String?): Int {
        requireNotNull(input) { "input must not be null" }
        require(input.isNotBlank()) { "input must not be blank" }
        return input.parse()
            .validate()
            .join()
    }

    private fun String.parse(): List<Equation> {
        return split(" ").map {
            when (it) {
                "+" -> Operator.Plus
                "-" -> Operator.Minus
                "*" -> Operator.Multiply
                "/" -> Operator.Divide
                else -> {
                    val number = it.toIntOrNull()
                    requireNotNull(number) { "input must be number" }
                    Equation.Number(number)
                }
            }
        }
    }

    private fun List<Equation>.validate(): List<Equation> {
        require(size % 2 == 1) { "input must be odd" }
        require(first() is Equation.Number) { "input must start with number" }
        require(last() is Equation.Number) { "input must end with number" }
        require(indexOfFirst { it is Operator } % 2 == 1) { "input must be number-operator-number" }
        return this
    }

    private fun List<Equation>.join(): Int {
        var result = 0
        var operator: Operator? = null
        forEach { equation ->
            when (equation) {
                is Equation.Number -> {
                    result = handleOperator(operator, result, equation)
                }

                is Operator -> {
                    operator = equation
                }
            }
        }
        return result
    }

    private fun handleOperator(
        operator: Operator?,
        result: Int,
        equation: Equation.Number
    ): Int {
        return when (operator) {
            Operator.Plus -> result + equation.value
            Operator.Minus -> result - equation.value
            Operator.Multiply -> result * equation.value
            Operator.Divide -> result / equation.value
            null -> equation.value
        }
    }
}
