package calculator

import calculator.model.Numbers
import calculator.model.Operators
import calculator.validator.InputValidator

object Calculator {
    private const val DELIMITER = " "
    private const val FIRST_INDEX = 0

    fun execute(input: String?): Int {
        val expression = InputValidator.validateInput(input)

        val numbers = Numbers.of(makeNumberList(expression))
        val operators = makeOperatorList(expression)

        InputValidator.validateSize(numbers.size(), operators.size)

        return calculate(numbers, operators)
    }

    private fun makeNumberList(expression: String): List<String> {
        return expression.split(DELIMITER).filterIndexed { index, _ -> index % 2 == 0 }
    }

    private fun makeOperatorList(expression: String): List<Operators> {
        return expression.split(DELIMITER).filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operators.validateOperator(it) }
    }

    private fun calculate(numbers: Numbers, operators: List<Operators>): Int {
        var result = numbers.first()
        val adjustNumbers = numbers.getNumbersExcludingFirst()
        for (index in FIRST_INDEX..adjustNumbers.lastIndex) {
            result = operators[index].operate(result, adjustNumbers[index])
        }
        return result
    }
}
