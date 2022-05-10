package stringCalculator

class Validator {

    fun isValidInput(input: String?): Boolean {
        require(!isNullOrBlank(input)) { INPUT_NULL_OR_BLANK }
        require(!containsNonOperator(input)) { INVALID_OPERATOR }
        startWithNumber(input)?.let { require(it) { INPUT_NOT_START_WITH_NUMBER } }
        endWithNumber(input)?.let { require(it) { INPUT_NOT_END_WITH_NUMBER } }
        require(!containsCharacter(input)) { INPUT_CONTAINS_CHARACTER }
        return true
    }

    private fun isNullOrBlank(input: String?): Boolean {
        return input.isNullOrBlank()
    }

    private fun containsNonOperator(input: String?): Boolean {
        input?.forEach { c: Char ->
            if (!c.isDigit() && !isOperator(c)) return true
        }
        return false
    }

    private fun startWithNumber(input: String?): Boolean? {
        return input?.get(0)?.isDigit()
    }

    private fun endWithNumber(input: String?): Boolean? {
        return input?.last()?.isDigit()
    }

    private fun containsCharacter(input: String?): Boolean {
        input?.forEach { c: Char ->
            if (c.isLetter()) return true
        }
        return false
    }

    private fun isOperator(c: Char?): Boolean {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == ' ')
    }
}
