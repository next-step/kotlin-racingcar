import java.lang.IllegalArgumentException

class StringCalculator {
    val validRegex = Regex(pattern = "^[ 0-9+*\\-=\\/]+$")
    fun validateStringForCalculate(str: String?) {
        if (str == null) {
            throw IllegalArgumentException("null is not acceptable")
        }
        if (!validRegex.matches(str)) {
            throw IllegalArgumentException("$str is not acceptable")
        }
    }
}
