package calculator

import common.Constant

object FourArithmetic {

    private val execute: ((operationNumbers: OperationNumbers) -> Int)? = null
    private const val NOT_FOUR_ARITHMETIC = "사칙연산 기호가 아닙니다."
    private const val NOT_ZERO_NUMBER_DIVISION = "0으로는 나눌 수 없습니다."

    fun confirmFourArithmetic(arithmetic: String, operationNumbers: OperationNumbers): Int {
        return when (arithmetic) {
            "+" -> plus(operationNumbers)
            "-" -> minus(operationNumbers)
            "*" -> multiply(operationNumbers)
            "/" -> division(operationNumbers)
            else -> throw IllegalArgumentException(NOT_FOUR_ARITHMETIC)
        }
    }

    fun plus(operationNumbers: OperationNumbers): Int {
        execute.apply { return operationNumbers.firstNumber.plus(operationNumbers.secondNumber) }
    }

    fun minus(operationNumbers: OperationNumbers): Int {
        execute.apply { return operationNumbers.firstNumber.minus(operationNumbers.secondNumber) }
    }

    fun multiply(operationNumbers: OperationNumbers): Int {
        execute.apply { return operationNumbers.firstNumber.times(operationNumbers.secondNumber) }
    }

    fun division(operationNumbers: OperationNumbers): Int {
        if (confirmSecondNumberZero(operationNumbers)) {
            throw ArithmeticException(NOT_ZERO_NUMBER_DIVISION)
        }
        execute.apply { return operationNumbers.firstNumber.div(operationNumbers.secondNumber) }
    }

    private fun confirmSecondNumberZero(operationNumbers: OperationNumbers) =
        operationNumbers.secondNumber == Constant.DIVISION_FIRST_VALUE_ZERO
}
