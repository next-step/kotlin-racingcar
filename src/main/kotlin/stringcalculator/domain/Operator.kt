package stringcalculator.domain

import java.util.function.BinaryOperator

enum class Operator(private val sign: String, private val operation: BinaryOperator<Int>) {

    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun of(sign: String): Operator {
            values().find { it.sign == sign }
                ?.let { return it }
                .run { throw IllegalArgumentException("연산할 수 없는 기호입니다. 기호: $sign") }
        }
    }

    fun calculate(left: Int, right: Int): Int {
        if (this == DIVIDE && right == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }

        return operation.apply(left, right)
    }
}
