package org.bmsk.calculator

import org.bmsk.calculator.ErrorMessage.DIVISION_BY_ZERO
import org.bmsk.calculator.ErrorMessage.NOT_A_NUMBER

internal object StringCalculator {

    fun plus(operand1: String, operand2: String): String {
        val num1 = operand1.safelyConvertToFloat()
        val num2 = operand2.safelyConvertToFloat()
        return (num1 + num2).toString()
    }

    fun minus(operand1: String, operand2: String): String {
        val num1 = operand1.safelyConvertToFloat()
        val num2 = operand2.safelyConvertToFloat()
        return (num1 - num2).toString()
    }

    fun multiply(operand1: String, operand2: String): String {
        val num1 = operand1.safelyConvertToFloat()
        val num2 = operand2.safelyConvertToFloat()
        return (num1 * num2).toString()
    }

    fun divide(operand1: String, operand2: String): String {
        val num1 = operand1.safelyConvertToFloat()
        val num2 = operand2.safelyConvertToFloat()
        if (num2 == 0f) {
            throw IllegalArgumentException(DIVISION_BY_ZERO)
        }
        return (num1 / num2).toString()
    }

    private fun String.safelyConvertToFloat(): Float {
        return try {
            this.toFloat()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(NOT_A_NUMBER)
        }
    }
}
