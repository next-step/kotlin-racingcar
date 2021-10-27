package calculator

import common.Constant
import common.ErrorMessage

object FourArithmetic {

    private val execute: ((operationNumbers: OperationNumbers) -> Int)? = null

    fun confirmFourArithmetic(arithmetic: String, operationNumbers: OperationNumbers): Int {
        return when (arithmetic) {
            "+" -> plus(operationNumbers)
            "-" -> minus(operationNumbers)
            "*" -> multiply(operationNumbers)
            "/" -> if (confirmSecondNumberZero(operationNumbers)) throw ArithmeticException(ErrorMessage.NOT_ZERO_NUMBER_DIVISION)
            else div(operationNumbers)
            else -> throw IllegalArgumentException(ErrorMessage.NOT_FOUR_ARITHMETIC)
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

    fun div(operationNumbers: OperationNumbers): Int {
        execute.apply { return operationNumbers.firstNumber.div(operationNumbers.secondNumber) }
    }

    private fun confirmSecondNumberZero(operationNumbers: OperationNumbers) =
        operationNumbers.secondNumber == Constant.DIVISION_FIRST_VALUE_ZERO
}
