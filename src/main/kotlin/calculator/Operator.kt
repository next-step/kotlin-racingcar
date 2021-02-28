package calculator

import java.lang.IllegalArgumentException

enum class Operator(val operator: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVISION("/");

    companion object {
        fun operatorOf(operator: String): Operator {
            return when (operator) {
                PLUS.operator -> PLUS
                MINUS.operator -> MINUS
                MULTIPLY.operator -> MULTIPLY
                DIVISION.operator -> DIVISION
                else -> throw IllegalArgumentException("잘못된 연산자입니다.")
            }
        }
    }
}
