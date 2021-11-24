package racingcar.util

object Parser {
    private const val SEPARATOR = ","

    fun separateBySeparator(input: String): List<String> = input.trim().split(SEPARATOR)
}
