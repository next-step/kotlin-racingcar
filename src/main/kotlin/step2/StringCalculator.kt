package step2

import step2.CalculatorParser.getFirstValue
import step2.CalculatorParser.getNextValue
import step2.CalculatorValidator.validateSize

object StringCalculator {
    private const val PLUS = "+"
    private const val MINUS = "-"
    private const val MULTIPLY = "*"
    private const val DIVIDE = "/"
    private const val FIRST_OPERATOR_INDEX = 1
    private const val OPERATOR_GAP = 2
    private const val NULL_OR_BLANK_ERROR_MSG = "입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw"
    private const val UNSUPPORTED_OPERATOR_MSG = "지원하지 않는 연산자입니다."

    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { NULL_OR_BLANK_ERROR_MSG }
        val elements = CalculatorParser.split(input)
        return calculate(elements)
    }

    private fun calculate(elements: List<String>): Int {
        validateSize(elements.size)
        var result = getFirstValue(elements)
        var operatorIndex = FIRST_OPERATOR_INDEX
        while (operatorIndex < elements.size) {
            val nextValue = getNextValue(elements, operatorIndex)
            val operation = elements[operatorIndex]
            result = applyOperation(result, nextValue, operation)
            operatorIndex += OPERATOR_GAP
        }
        return result
    }

    private fun applyOperation(currentResult: Int, nextValue: Int, operation: String): Int {
        return when (operation) {
            PLUS -> currentResult + nextValue
            MINUS -> currentResult - nextValue
            MULTIPLY -> currentResult * nextValue
            DIVIDE -> currentResult / nextValue
            else -> throw IllegalArgumentException(UNSUPPORTED_OPERATOR_MSG)
        }
    }
}
