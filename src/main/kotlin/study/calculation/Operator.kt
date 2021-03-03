package study.calculation

import java.lang.IllegalArgumentException

enum class Operator(val oper: String, val calculation: Calculation) {
    ADDITON("+", Addition()),
    SUBTRACTION("-", Subtraction()),
    MULTIPLICATION("*", Multiplication()),
    DIVISION("/", Division());

    companion object {
        fun select(oper: String): Operator =
            values().find { oper == it.oper } ?: throw IllegalArgumentException("지원하는 연산자가 아닙니다.")
    }
}
