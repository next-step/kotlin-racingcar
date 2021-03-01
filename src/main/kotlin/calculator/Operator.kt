package calculator

import java.lang.IllegalArgumentException

enum class Operator(val operator: String) {
    PLUS("+") {
        override fun operate(leftOperand: Int, rightOperand: Int): Int {
            return Calculator.add(leftOperand, rightOperand)
        }
    },
    MINUS("-") {
        override fun operate(leftOperand: Int, rightOperand: Int): Int {
            return Calculator.minus(leftOperand, rightOperand)
        }
    },
    MULTIPLY("*") {
        override fun operate(leftOperand: Int, rightOperand: Int): Int {
            return Calculator.multiply(leftOperand, rightOperand)
        }
    },
    DIVISION("/") {
        override fun operate(leftOperand: Int, rightOperand: Int): Int {
            return Calculator.division(leftOperand, rightOperand)
        }
    };

    abstract fun operate(leftOperand: Int, rightOperand: Int): Int

    companion object {
        fun operatorOf(operator: String): Operator {
            return when (operator) {
                PLUS.operator -> PLUS
                MINUS.operator -> MINUS
                MULTIPLY.operator -> MULTIPLY
                DIVISION.operator -> DIVISION
                else -> throw IllegalArgumentException("잘못된 연산자입니다.")
            }
        }
    }
}
