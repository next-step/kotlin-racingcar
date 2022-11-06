package calculator

import java.lang.IllegalArgumentException
import java.util.function.BiFunction

enum class Operator(
    private val operator: String,
    private val expression: BiFunction<Int, Int, Int>
) {
    PLUS(
        operator = "+",
        expression = BiFunction { num1, num2 -> num1 + num2 }
    ),
    MINUS(
        operator = "-",
        expression = BiFunction { num1, num2 -> num1 - num2 }
    ),
    MULTIPLY(
        operator = "*",
        expression = BiFunction { num1, num2 -> num1 * num2 }
    ),
    DIVIDE(
        operator = "/",
        expression = BiFunction { num1, num2 -> num1 / num2 }
    ),
    ;

    companion object {
        fun findByStringOperator(operator: String): Operator {
            return Operator.values()
                .find { it.operator == operator } ?: throw IllegalArgumentException("문자열 계산기에서 지원하지 않는 연산자에요.")
        }
    }

    fun execute(num1: Int, num2: Int): Int {
        return this.expression.apply(num1, num2)
    }
}
