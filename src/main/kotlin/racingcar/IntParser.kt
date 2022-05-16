package racingcar

object IntParser {
    fun toInt(input: String?): Int {
        return input?.toIntOrNull() ?: throw IllegalArgumentException("올바른 정수로 입력해주세요. 입력값: $input")
    }
}
