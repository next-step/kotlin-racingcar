package step2.calculator

import java.util.function.BiFunction

enum class Operator(
    private val symbol: String,
    private val function: BiFunction<Double, Double, Double>
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDED("/", { a, b -> a / b })
    ;

    fun operate(first: String, second: String): Double {
        return function.apply(toDouble(first), toDouble(second))
    }

    private fun toDouble(value: String): Double {
        return try {
            value.toDouble()
        } catch (cause: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닙니다. cause = `$value`")
        }
    }

    companion object {
        fun getOperator(symbol: String): Operator {
            val matched = Operator.values().firstOrNull { it.symbol == symbol }
            if (matched != null) {
                return matched
            }
            throw IllegalArgumentException("해당 연산자를 찾을 수 없습니다. `$symbol`")
        }
    }
}
