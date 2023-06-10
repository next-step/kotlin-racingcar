package racingcar.util

object InputParser {
    @Throws(IllegalArgumentException::class)
    fun parseCarNames(input: String): List<String> {
        require(input.isNotBlank()) { "이름을 한 개 이상 입력해주세요" }
        return input.split(",")
    }
}
