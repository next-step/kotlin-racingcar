package step2.calculator.utils

class CustomStringParser {

    companion object {
        fun parse(str: String?): List<String> {
            validate(str)

            return str!!.split(DELIMITER)
        }

        fun removeEmptyStrings(list: List<String>): List<String> {
            return list.filter { it.isNotBlank() }
        }

        private fun validate(str: String?) {
            if (str.isNullOrBlank()) {
                throw IllegalArgumentException()
            }
        }

        private const val DELIMITER = " "
    }
}
