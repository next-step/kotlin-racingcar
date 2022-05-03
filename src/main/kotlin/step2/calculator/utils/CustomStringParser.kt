package step2.calculator.utils

class CustomStringParser {

    companion object {
        fun parse(str: String?): List<String> {
            validate(str)

            return str!!.split(DELIMITER)
        }

        private fun validate(str: String?) {
            if (str.isNullOrBlank()) {
                throw IllegalArgumentException()
            }
        }

        private const val DELIMITER = " "
    }
}
