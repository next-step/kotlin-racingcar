package calculator

object NumberParser {

    fun parse(value: String): Int {
        return value.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
    }
}
