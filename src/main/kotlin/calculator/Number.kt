package calculator

import java.lang.IllegalArgumentException

data class Number constructor(
    val value: Int
) {
    companion object {
        fun from(value: String): Number = try {
            Number(value.toInt())
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("\"$value\" 는 정수가 아닙니다.")
        }
    }
}
