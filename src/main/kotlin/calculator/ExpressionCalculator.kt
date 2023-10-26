package calculator

import calculator.CalculatorParser.getFirstValue
import calculator.CalculatorParser.getNextValue

object ExpressionCalculator {

    private const val FIRST_OPERATOR_INDEX = 1
    private const val OPERATOR_GAP = 2

    fun calculate(input: String?): Int {
        val validatedInput = CalculatorValidator.validateInput(input)

        val elements = CalculatorParser.split(validatedInput)

        var result = elements.getFirstValue()
        var operatorIndex = FIRST_OPERATOR_INDEX
        while (operatorIndex < elements.size) {
            val nextValue = elements.getNextValue(operatorIndex)
            val operation = Operation.fromString(elements[operatorIndex])
            result = Calculator.applyOperation(result, nextValue, operation)
            operatorIndex += OPERATOR_GAP
        }
        return result
    }
}
