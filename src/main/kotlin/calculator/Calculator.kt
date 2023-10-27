package calculator

import calculator.enums.Operators
import calculator.validator.InputValidator
import calculator.validator.NumberValidator
import calculator.validator.OperatorValidator

object Calculator {
    private const val DELIMITER = " "
    private const val FIRST_INDEX = 0

    fun execute(input: String?): Int {
        val expression = InputValidator.validateInput(input)

        val numbers = makeNumberList(expression)
        val operators = makeOperatorList(expression)

        InputValidator.validateSize(numbers, operators)

        return calculate(numbers, operators)
    }

    private fun makeNumberList(expression: String): MutableList<Int> {
        return expression.split(DELIMITER).filterIndexed { index, _ -> index % 2 == 0 }
            .map { NumberValidator.validateNumber(it) }.toMutableList()
    }

    private fun makeOperatorList(expression: String): List<Operators> {
        return expression.split(DELIMITER).filterIndexed { index, _ -> index % 2 == 1 }
            .map { OperatorValidator.validateOperator(it) }
    }

    private fun calculate(numbers: MutableList<Int>, operators: List<Operators>): Int {
        var result = numbers.removeAt(FIRST_INDEX)
        for (index in FIRST_INDEX..numbers.lastIndex) {
            result = operators[index].operate(result, numbers[index])
        }
        return result
    }
}
