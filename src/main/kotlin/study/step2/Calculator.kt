package study.step2

import study.step2.equation.Equation
import study.step2.equation.Equation.Operator

object Calculator {

    fun calculate(input: String?): Int {
        requireNotNull(input)
        require(input.isNotBlank())
        return input.parse().join()
    }

    private fun String.parse(): List<Equation> {
        return split(" ").map {
            when (it) {
                "+" -> Operator.Plus
                "-" -> Operator.Minus
                "*" -> Operator.Multiply
                "/" -> Operator.Divide
                else -> runCatching<Equation.Number> {
                    Equation.Number(it.toInt())
                }.getOrElse {
                    throw IllegalArgumentException()
                }
            }
        }
    }

    private fun List<Equation>.join(): Int {
        var result = 0
        var operator: Operator? = null
        forEach { equation ->
            when (equation) {
                is Equation.Number -> {
                    when (operator) {
                        Operator.Plus -> result += equation.value
                        Operator.Minus -> result -= equation.value
                        Operator.Multiply -> result *= equation.value
                        Operator.Divide -> result /= equation.value
                        null -> result = equation.value
                    }
                }

                is Operator -> {
                    operator = equation
                }
            }
        }
        return result
    }
}
