package step2

import step2.CalculatorParser.getNextValue

object ExpressionCalculator {

    private const val FIRST_OPERATOR_INDEX = 1
    private const val OPERATOR_GAP = 2

    fun calculate(input: String?): Int {
        val validatedInput = CalculatorValidator.validateInput(input)

        val elements = CalculatorParser.split(validatedInput)

        CalculatorValidator.validateSize(elements.size)

        var result = elements.first().toInt()
        var operatorIndex = FIRST_OPERATOR_INDEX
        while (operatorIndex < elements.size) {
            val nextValue = elements.getNextValue(operatorIndex)
            val operation = elements[operatorIndex]
            result = StringCalculator.applyOperation(result, nextValue, operation)
            operatorIndex += OPERATOR_GAP
        }
        return result
    }
}
