package calculator

import java.lang.IllegalArgumentException

enum class Operator(private val sign: String, val execute: (Double, Double) -> Double) {
    PLUS("+", { oldNum, newNum -> oldNum + newNum }),
    MINUS("-", { oldNum, newNum -> oldNum - newNum }),
    MULTIPLY("*", { oldNum, newNum -> oldNum * newNum }),
    DIVIDE("/", { oldNum, newNum -> oldNum / newNum });

    companion object {
        fun of(sign: String): Operator {
            try {
                return values().first { it.sign == sign }
            } catch (e: NoSuchElementException) {
                throw IllegalArgumentException("사칙연산 기호가 아닌 잘못된 값이 전달되었습니다.")
            }
        }
    }
}
