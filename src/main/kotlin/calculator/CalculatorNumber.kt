package calculator

import java.lang.IllegalArgumentException

data class CalculatorNumber constructor(
    val value: Int
) {
    companion object {
        fun from(value: String): CalculatorNumber = try {
            CalculatorNumber(value.toInt())
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("\"$value\" 는 정수가 아닙니다.")
        }
    }
}
