package domain

import constant.Constants.Companion.ADDITION
import constant.Constants.Companion.DIVISION
import constant.Constants.Companion.MULTIPLICATION
import constant.Constants.Companion.SUBTRACT
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class ValidationChecker {

    fun checkNullAndBlankValidation(input: String?) {
        checkNull(input)
        checkBlank(input)
    }

    fun checkNull(input: String?) {
        if (input == null) {
            println("Null")
            throw IllegalArgumentException()
        }
    }

    fun checkBlank(input: String?) {
        if (input == "") {
            println("Blank")
            throw IllegalArgumentException()
        }
    }

    fun checkValidNumber(input: String?) {
        try {
            input?.toDouble()
        } catch (e: NumberFormatException) {
            println("Invalid Operand")
            throw IllegalArgumentException()
        }
    }

    fun checkValidOperator(input: String?) {
        if (!(input == ADDITION || input == SUBTRACT || input == DIVISION || input == MULTIPLICATION)) {
            println("Invalid Operation")
            throw IllegalArgumentException()
        }
    }

    fun isOperator(input: String?): Boolean {
        if (!(input == ADDITION || input == SUBTRACT || input == DIVISION || input == MULTIPLICATION)) {
            return false
        }
        return true
    }
}
