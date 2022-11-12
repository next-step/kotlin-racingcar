package calculator

import java.lang.IllegalArgumentException

enum class Operator(
    private val operator: String,
    private val expression: (Int, Int) -> Int
) {
    PLUS(
        operator = "+",
        expression = { num1, num2 -> num1 + num2 }
    ),
    MINUS(
        operator = "-",
        expression = { num1, num2 -> num1 - num2 }
    ),
    MULTIPLY(
        operator = "*",
        expression = { num1, num2 -> num1 * num2 }
    ),
    DIVIDE(
        operator = "/",
        expression = { num1, num2 -> num1 / num2 }
    ),
    ;

    fun execute(num1: Int, num2: Int): Int {
        return this.expression(num1, num2)
    }

    companion object {
        fun findByStringOperator(operator: String): Operator {
            return values().find { it.operator == operator }
                ?: throw IllegalArgumentException("${operator}는 문자열 계산기에서 지원하지 않는 연산자에요.")
        }
    }
}
