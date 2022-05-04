package step2.calculator.utils

class CustomStringParser {

    companion object {
        fun parse(str: String?): List<String> {
            if (str.isNullOrBlank()) {
                throw IllegalArgumentException()
            }

            return str.split(DELIMITER)
        }

        fun removeEmptyStrings(list: List<String>): List<String> {
            return list.filter { it.isNotBlank() }
        }

        private const val DELIMITER = " "
    }
}
