package step2

import java.util.function.IntBinaryOperator

enum class Operator(val operator: String) : IntBinaryOperator {
    PLUS("+") {
        override fun applyAsInt(left: Int, right: Int): Int {
            return left + right
        }
    },
    MINUS("-") {
        override fun applyAsInt(left: Int, right: Int): Int {
            return left - right
        }
    },
    MULTIPLY("*") {
        override fun applyAsInt(left: Int, right: Int): Int {
            return left * right
        }
    },
    DIVIDE("/") {
        override fun applyAsInt(left: Int, right: Int): Int {
            return left / right
        }
    };

    companion object {
        fun getOperator(operator: String): Operator = values().find {
            it.operator == operator
        } ?: throw IllegalArgumentException("올바른 연산자가 아닙니다")
    }
}