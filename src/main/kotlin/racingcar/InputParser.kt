package racingcar

object InputParser {

    fun toInt(input: String?): Int {
        return input?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력 입니다 `$input`")
    }
}
