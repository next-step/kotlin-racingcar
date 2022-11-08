package domain

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class ValidationChecker {
    companion object {
        const val ADDITION = "+"
        const val SUBTRACT = "-"
        const val DIVISION = "/"
        const val MULTIPLICATION = "*"
    }

    fun checkNullAndBlankValidation(input: String?) {
        checkNull(input)
        checkBlank(input)
    }

    fun checkNull(input: String?) {
        if (input == null) {
            throw IllegalArgumentException("Null")
        }
    }

    fun checkBlank(input: String?) {
        if (input == "") {
            throw IllegalArgumentException("Blank")
        }
    }

    fun checkValidNumber(input: String?) {
        try {
            input?.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid Operand")
        }
    }

    fun checkValidOperator(input: String?) {
        if (!(input == ADDITION || input == SUBTRACT || input == DIVISION || input == MULTIPLICATION)) {
            throw IllegalArgumentException("Invalid Operation")
        }
    }

    fun isOperator(input: String?): Boolean {
        if (!(input == ADDITION || input == SUBTRACT || input == DIVISION || input == MULTIPLICATION)) {
            return false
        }
        return true
    }
}
