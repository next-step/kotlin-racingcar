package stringcalculator.domain

import java.util.function.BinaryOperator

enum class Operator(private val sign: String, private val operation: BinaryOperator<Int>) {

    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        if (b == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }

        a / b
    });

    companion object {
        fun of(sign: String): Operator {
            return values().find { it.sign == sign } ?: throw IllegalArgumentException("연산할 수 없는 기호입니다. 기호: $sign")
        }
    }

    fun calculate(left: Int, right: Int): Int {
        return operation.apply(left, right)
    }
}
