package calculator

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

// NOTE: 코틀린 공식 문서 참고(https://kotlinlang.org/docs/enum-classes.html#implementing-interfaces-in-enum-classes)
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(left: Int, right: Int): Int = left + right
    },
    MINUS {
        override fun apply(left: Int, right: Int): Int = left - right
    },
    TIMES {
        override fun apply(left: Int, right: Int): Int = left * right
    },
    DIVIDES {
        override fun apply(left: Int, right: Int): Int {
            if (right == 0) {
                throw IllegalArgumentException("숫자는 0으로 나눌 수 없습니다.")
            }
            return left / right
        }
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)

    companion object {
        fun from(token: String): IntArithmetics {
            when (token) {
                "+" -> return IntArithmetics.PLUS
                "-" -> return IntArithmetics.MINUS
                "*" -> return IntArithmetics.TIMES
                "/" -> return IntArithmetics.DIVIDES
            }
            throw IllegalArgumentException("허용되지 않은 연산자 입니다.")
        }
    }
}
