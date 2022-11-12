package calculator.domain

import java.lang.IllegalArgumentException

const val OPERATOR = 1
const val INPUT_VALUE_DELIMITER = " "

class CalculationExpression(inputValue: String) {
    val operand: Operand
    val arithmeticOperator: ArithmeticOperator
    private val operands = ArrayList<Double>()
    private val operators = ArrayList<String>()
    private val splitInput: List<String>

    companion object {
        const val ADDITION = "+"
        const val SUBTRACT = "-"
        const val DIVISION = "/"
        const val MULTIPLICATION = "*"
    }

    init {
        splitInput = splitInputValue(inputValue)

        if (isOperator(splitInput[0])) {
            throw IllegalArgumentException()
        }

        for (i in 0 until splitInputValue(inputValue).size) {
            createSplitInputList(i)
        }

        operand = Operand(operands)
        arithmeticOperator = ArithmeticOperator(operators)
    }

    private fun isOperator(input: String): Boolean {
        if (!(input == ADDITION || input == SUBTRACT || input == DIVISION || input == MULTIPLICATION)) {
            return false
        }
        return true
    }

    private fun splitInputValue(inputValue: String): List<String> {
        return inputValue.split(INPUT_VALUE_DELIMITER)
    }

    private fun createSplitInputList(index: Int) {
        checkBlank(splitInput[index])

        if (isOperatorInputTurn(index)) {
            operators.add(splitInput[index])
            return
        }
        operands.add(splitInput[index].toDouble())
    }

    private fun isOperatorInputTurn(i: Int): Boolean {
        return i % 2 == OPERATOR
    }

    private fun checkBlank(input: String) {
        if (input == "") {
            throw IllegalArgumentException("Blank")
        }
    }
}
