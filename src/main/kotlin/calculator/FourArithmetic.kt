package calculator

import common.Constant
import common.ErrorMessage
import java.util.function.BinaryOperator

enum class FourArithmetic : BinaryOperator<Int> {
    PLUS {
        override fun apply(firstValue: Int, secondValue: Int) = firstValue.plus(secondValue)
    },
    MINUS {
        override fun apply(firstValue: Int, secondValue: Int) = firstValue.minus(secondValue)
    },
    MULTIPLY {
        override fun apply(firstValue: Int, secondValue: Int) = firstValue.times(secondValue)
    },
    DIVISION {
        override fun apply(firstValue: Int, secondValue: Int) = firstValue.div(secondValue)
    };
}

fun confirmFourArithmetic(arithmetic: String, operationNumbers: Pair<Int, Int>): Int {
    return when (arithmetic) {
        "+" -> FourArithmetic.PLUS.apply(operationNumbers.first, operationNumbers.second)
        "-" -> FourArithmetic.MINUS.apply(operationNumbers.first, operationNumbers.second)
        "*" -> FourArithmetic.MULTIPLY.apply(operationNumbers.first, operationNumbers.second)
        "/" -> if (confirmFirstNumberZero(operationNumbers)) throw ArithmeticException(ErrorMessage.NOT_ZERO_NUMBER_DIVISION)
        else FourArithmetic.DIVISION.apply(operationNumbers.first, operationNumbers.second)
        else -> throw IllegalArgumentException(ErrorMessage.NOT_FOUR_ARITHMETIC)
    }
}

private fun confirmFirstNumberZero(operationNumbers: Pair<Int, Int>) =
    operationNumbers.toList().contains(Constant.DIVISION_FIRST_VALUE_ZERO)
