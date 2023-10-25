package org.bmsk.calculator

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
            throw IllegalArgumentException("적절하지 않은 입력: 0으로 나눗셈을 시도함.")
        }
        return (num1 / num2).toString()
    }

    private fun String.safelyConvertToFloat(): Float {
        return try {
            this.toFloat()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("적절하지 않은 입력: '$this'는 유효한 숫자가 아님.")
        }
    }
}
