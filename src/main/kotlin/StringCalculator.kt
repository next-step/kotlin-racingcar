class StringCalculator {
    val VALID_REGEX = Regex(pattern = "^[ 0-9+*\\-=\\/]+$")
    val DELIMITER = " "

    fun validateStringForCalculate(str: String?) {
        if (str == null) {
            throw IllegalArgumentException("null is not acceptable")
        }
        if (!str.contains(" ")) {
            throw IllegalArgumentException("$str is not acceptable")
        }
        if (!VALID_REGEX.matches(str)) {
            throw IllegalArgumentException("$str is not acceptable")
        }
    }

    fun splitForCalculate(str: String): List<String> {
        return str.split(DELIMITER)
    }
}
