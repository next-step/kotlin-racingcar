package step2

import java.lang.IllegalArgumentException

class Operator {

    private fun plus(number1: Int, number2: Int): Int {
        return number1 + number2
    }

    private fun minus(number1: Int, number2: Int): Int {
        return number1 - number2
    }

    private fun multiply(number1: Int, number2: Int): Int {
        return number1 * number2
    }

    private fun divide(number1: Int, number2: Int): Int {
        return number1 / number2
    }

    fun operate(number1: Int, number2: Int, operator: String): Int {
        when (operator) {
            "+" -> {
                return plus(number1, number2)
            }
            "-" -> {
                return minus(number1, number2)
            }
            "*" -> {
                return multiply(number1, number2)
            }
            "/" -> {
                return divide(number1, number2)
            }
            else -> {
                throw IllegalArgumentException("계산식에 올바르지 않은 사칙연상이 있습니다.")
            }
        }
    }
}
