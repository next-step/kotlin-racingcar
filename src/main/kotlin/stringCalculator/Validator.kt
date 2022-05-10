package stringCalculator

class Validator {

    fun isValidInput(input: String): Boolean {
        return (
            !isNullOrBlank(input) &&
                !containsNonOperator(input) &&
                startWithNumber(input) &&
                endWithNumber(input) &&
                !containsCharacter(input)
            )
    }

    private fun isNullOrBlank(input: String): Boolean {
        return input.isNullOrBlank()
    }

    private fun containsNonOperator(input: String): Boolean {
        input.forEach { c: Char ->
            if (!c.isDigit() || !isOperator(c)) return true
        }
        return false
    }

    private fun startWithNumber(input: String): Boolean {
        return input[0].isDigit()
    }

    private fun endWithNumber(input: String): Boolean {
        return input.last().isDigit()
    }

    private fun containsCharacter(input: String): Boolean {
        input.forEach { c: Char ->
            if (c.isLetter()) return true
        }
        return false
    }

    private fun isOperator(c: Char): Boolean {
        return (c == '+' || c == '-' || c == '*' || c == '/')
    }
}
