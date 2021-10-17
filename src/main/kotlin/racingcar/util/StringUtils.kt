package racingcar.util

class StringUtils {

    companion object {
        fun splitText(text: String, delimiter: String): List<String> {
            return try {
                text.split(delimiter)
            } catch (e: IllegalArgumentException) {
                emptyList()
            }
        }
    }
}
