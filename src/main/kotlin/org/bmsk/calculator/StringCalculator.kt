package org.bmsk.calculator

internal object StringCalculator {

    fun plus(operand1: String, operand2: String): Float {
        return try {
            operand1.toFloat() + operand2.toFloat()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("적절하지 않은 입력: '$operand1' 혹은 '$operand2'는 유효한 숫자가 아님.")
        }
    }

    fun minus(operand1: String, operand2: String): Float {
        return try {
            operand1.toFloat() - operand2.toFloat()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("적절하지 않은 입력: '$operand1' 혹은 '$operand2'는 유효한 숫자가 아님.")
        }
    }

    fun multiply(operand1: String, operand2: String): Float {
        return try {
            operand1.toFloat() * operand2.toFloat()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("적절하지 않은 입력: '$operand1' 혹은 '$operand2'는 유효한 숫자가 아님.")
        }
    }

    fun divide(operand1: String, operand2: String): Float {
        try {
            if (operand2.toFloat() == 0f) {
                throw IllegalArgumentException("적절하지 않은 입력: 0으로 나눗셈을 시도함.")
            }
            return operand1.toFloat() / operand2.toFloat()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("적절하지 않은 입력: '$operand1' 혹은 '$operand2'는 유효한 숫자가 아님.")
        }
    }
}
