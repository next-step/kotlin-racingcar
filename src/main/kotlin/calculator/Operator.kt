package calculator

import java.lang.IllegalArgumentException
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

private const val ZERO_EXCEPTION = "0으로는 나눌 수 없습니다."

enum class Operator : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int) = t + u
    },
    MINUS {
        override fun apply(t: Int, u: Int) = t - u
    },
    MUL {
        override fun apply(t: Int, u: Int) = t * u
    },
    DIV {
        override fun apply(t: Int, u: Int): Int {
            if (t == 0 || u == 0) {
                throw IllegalArgumentException(ZERO_EXCEPTION)
            }
            return t / u
        }
    };

    override fun applyAsInt(left: Int, right: Int) = apply(left, right)
}
