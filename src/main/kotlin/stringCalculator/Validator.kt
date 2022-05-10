package stringCalculator

class Validator {

    fun isValidInput(input: String?): Boolean {
        require(!isNullOrBlank(input)) { INPUT_NULL_OR_BLANK }
        require(!containsNonOperator(input)) { INVALID_OPERATOR }
        startWithNumber(input)?.let { require(it) { INPUT_NOT_START_WITH_NUMBER } }
        endWithNumber(input)?.let { require(it) { INPUT_NOT_END_WITH_NUMBER } }
        require(!containsCharacter(input)) { INPUT_CONTAINS_CHARACTER }
        require(!isOperatorOrNumberInARow(input)) { INPUT_CONTAINS_OPERATOR_IN_A_ROW }
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

    private fun isNumber(input: String): Boolean {
        input.forEach { n: Char -> if (!n.isDigit()) return false }
        return true
    }

    fun isOperatorOrNumberInARow(input: String?): Boolean {
        val inputList = input?.split(" ")
        var checkIfOperatorInARow = 0
        if (inputList != null) {
            for (item in inputList) {
                if (isNumber(item)) {
                    checkIfOperatorInARow++
                    if (checkIfOperatorInARow != 1) return true
                    continue
                }
                checkIfOperatorInARow--
                if (checkIfOperatorInARow != 0) return true
            }
        }
        return false
    }
}
