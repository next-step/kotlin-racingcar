package step2

import java.util.function.BinaryOperator

enum class Operator(val value: String, val function: BinaryOperator<Double>) {
    PLUS("+", { sum, operand -> sum + operand }),
    MINUS("-", { sum, operand -> sum - operand }),
    MULTIPLY("*", { sum, operand -> sum * operand }),
    DIVIDE("/", { sum, operand -> sum / operand });

    companion object {
        fun isIn(value: String): Boolean = values()
            .map { v -> v.value }
            .contains(value)
            .also { exist -> require(exist) { "사칙연산 기호가 아닙니다. $value" } }

        fun apply(value: String, sum: Double, operand: Double): Double {
            isIn(value)
            return values().first { v -> v.value.equals(value) }
                .function
                .apply(sum, operand)
        }
    }
}
