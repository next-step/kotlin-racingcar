package calculator

import java.lang.IllegalArgumentException

class Calculator {
    fun input(value: String): List<String> {
        validInputIsEmpty(value)

        return splitByWhiteSpace(value)
    }

    fun validInputIsEmpty(input: String?) {
        if (input == "") {
            throw IllegalArgumentException("입력 값이 존재하지 않습니다.")
        }
    }

    fun splitByWhiteSpace(input: String): List<String> {
        return input.split(" ")
    }

    fun calculate(splitInput: List<String>): Int {
        var operand = splitInput[0]

        for (index in 0 until splitInput.size - 2 step 2) {
            operand = applyOperator(operand.toInt(), splitInput[index + 2].toInt(), splitInput[index + 1]).toString()
        }

        return operand.toInt()
    }

    fun applyOperator(leftOperand: Int, rightOperand: Int, operator: String): Int {
        return when (operator) {
            Operator.PLUS.operator -> add(leftOperand, rightOperand)
            Operator.MINUS.operator -> minus(leftOperand, rightOperand)
            Operator.MULTIPLY.operator -> multiply(leftOperand, rightOperand)
            Operator.DIVISION.operator -> division(leftOperand, rightOperand)

            else -> throw IllegalArgumentException("잘못된 연산자입니다.")
        }
    }

    fun add(left: Int, right: Int): Int {
        return left + right
    }

    fun minus(left: Int, right: Int): Int {
        return left - right
    }

    fun multiply(left: Int, right: Int): Int {
        return left * right
    }

    fun division(left: Int, right: Int): Int {
        if (right == 0) {
            throw IllegalArgumentException("0은 분모가 될 수 없습니다.")
        }

        return left / right
    }
}
