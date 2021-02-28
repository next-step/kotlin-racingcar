package calculator

import java.lang.IllegalArgumentException

object Calculator {
    private const val FIRST_OPERAND = 0
    private const val START_INDEX = 0
    private const val OPERAND_INDEX = 2
    private const val OPERATOR_INDEX = 1
    private const val CALCULATOR_SEPARATOR = " "
    private const val SIZE_TO_LAST_OPERAND = 2

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
        return input.split(CALCULATOR_SEPARATOR)
    }

    fun calculate(splitInput: List<String>): Int {
        var operand = splitInput[FIRST_OPERAND]

        for (index in START_INDEX until splitInput.size - SIZE_TO_LAST_OPERAND step OPERAND_INDEX) {
            val operator = Operator.operatorOf(splitInput[index + OPERATOR_INDEX])
            operand = applyOperator(operand.toInt(), splitInput[index + OPERAND_INDEX].toInt(), operator).toString()
        }

        return operand.toInt()
    }

    fun applyOperator(leftOperand: Int, rightOperand: Int, operator: Operator): Int {
        return when (operator) {
            Operator.PLUS -> add(leftOperand, rightOperand)
            Operator.MINUS -> minus(leftOperand, rightOperand)
            Operator.MULTIPLY -> multiply(leftOperand, rightOperand)
            Operator.DIVISION -> division(leftOperand, rightOperand)
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
