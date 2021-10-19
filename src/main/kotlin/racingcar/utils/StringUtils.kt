package racingcar.utils

object StringUtils {

    fun splitText(text: String, delimiter: String): List<String> {
        return try {
            text.split(delimiter)
        } catch (e: IllegalArgumentException) {
            emptyList()
        }
    }
}
