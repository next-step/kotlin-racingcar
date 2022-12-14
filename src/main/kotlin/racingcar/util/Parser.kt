package racingcar.util

internal object Parser {

    fun parse(text: String, delimiter: String): List<String> {
        if (text.isBlank()) return emptyList()
        return text.split(delimiter)
    }
}
