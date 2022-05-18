package stringCalculator

import stringCalculator.Message.Companion.INPUT_CONTAINS_CHARACTER
import stringCalculator.Message.Companion.INPUT_CONTAINS_OPERATOR_IN_A_ROW
import stringCalculator.Message.Companion.INPUT_NOT_END_WITH_NUMBER
import stringCalculator.Message.Companion.INPUT_NOT_START_WITH_NUMBER
import stringCalculator.Message.Companion.INPUT_NULL_OR_BLANK
import stringCalculator.Message.Companion.INVALID_OPERATOR

class Validator {

    fun validateInput(input: String?): Boolean {
        require(!input.isNullOrBlank()) { INPUT_NULL_OR_BLANK }
        require(!containsNonOperator(input)) { INVALID_OPERATOR }
        startWithNumber(input)?.let { require(it) { INPUT_NOT_START_WITH_NUMBER } }
        endWithNumber(input)?.let { require(it) { INPUT_NOT_END_WITH_NUMBER } }
        require(!containsCharactor(input)) { INPUT_CONTAINS_CHARACTER }
        require(!isOperatorOrNumberInARow(input)) { INPUT_CONTAINS_OPERATOR_IN_A_ROW }
        return true
    }

    fun containsNonOperator(input: String?): Boolean {
        val inputWithOutBlank = input?.replace(" ", "")
        inputWithOutBlank?.forEach { c: Char ->
            if (!c.isDigit() && !isOperator(c)) return true
        }
        return false
    }

    fun startWithNumber(input: String?): Boolean? {
        return input?.firstOrNull()?.isDigit()
    }

    fun endWithNumber(input: String?): Boolean? {
        return input?.last()?.isDigit()
    }

    fun containsCharactor(input: String?): Boolean {
        input?.forEach { c: Char ->
            if (c.isLetter()) return true
        }
        return false
    }

    fun isOperator(c: Char?): Boolean {
        return (c == '+' || c == '-' || c == '*' || c == '/')
    }

    fun isNumber(input: String): Boolean {
        input.forEach { n: Char -> if (!n.isDigit()) return false }
        return true
    }

    fun isOperatorOrNumberInARow(input: String?): Boolean {
        val inputList = input!!.split(" ")
        var checkIfOperatorInARow = 0
        for (item in inputList) {
            if (isNumber(item)) {
                checkIfOperatorInARow++
            } else {
                checkIfOperatorInARow--
            }
            if (checkIfOperatorInARow != 1 || checkIfOperatorInARow != 0) return true
        }
        return false
    }
}
