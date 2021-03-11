package domain.calculator

import java.lang.IllegalArgumentException

enum class Operator(val operator: String, val operate: (leftOperand: Int, rightOperand: Int) -> Int) {
    PLUS("+", { leftOperand, rightOperand -> Calculator.add(leftOperand, rightOperand) }),
    MINUS("-", { leftOperand, rightOperand -> Calculator.minus(leftOperand, rightOperand) }),
    MULTIPLY("*", { leftOperand, rightOperand -> Calculator.multiply(leftOperand, rightOperand) }),
    DIVISION("/", { leftOperand, rightOperand -> Calculator.division(leftOperand, rightOperand) });

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
