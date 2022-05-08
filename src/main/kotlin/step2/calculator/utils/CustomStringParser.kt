package step2.calculator.utils

object CustomStringParser {
    private const val DELIMITER = " "

    fun splitAsWords(str: String?): List<String> {
        if (str.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        return str.split(DELIMITER)
    }

    fun removeEmptyStrings(list: List<String>): List<String> {
        return list.filter { it.isNotBlank() }
    }
}
