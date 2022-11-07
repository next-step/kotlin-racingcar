package step2

import java.lang.IllegalArgumentException

enum class Operator(
    val sign: String,
    val formula: (Int, Int) -> Int
) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    DIVIDE("/", { left, right -> left / right });

    fun calculate(left: Int, right: Int): Int {
        return formula(left, right)
    }

    companion object {
        fun from(sign: String): Operator {
            return values().find { it.sign == sign } ?: throw IllegalArgumentException("Operator의 종류는 +-*/ 중 하나여야 합니다.")
        }
    }
}
