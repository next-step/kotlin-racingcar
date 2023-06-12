package racingcar.util

object InputParser {
    private const val COMMA = ","

    @Throws(IllegalArgumentException::class)
    fun parseCarNames(input: String, separator: String = COMMA): List<String> {
        return input.split(separator)
    }
}
