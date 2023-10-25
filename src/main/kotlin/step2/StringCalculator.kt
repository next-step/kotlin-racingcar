package step2

object StringCalculator {
    private const val PLUS = "+"
    private const val MINUS = "-"
    private const val MULTIPLY = "*"
    private const val DIVIDE = "/"
    private const val OPERAND_OFFSET = 1
    private const val FIRST_OPERATOR_INDEX = 1
    private const val EVEN_NUMBER_DENOMINATOR = 2
    private const val EVEN_NUMBER_REMAINDER = 0
    private const val OPERATOR_GAP = 2
    private const val FIRST_VALUE_INDEX = 0
    private const val NULL_OR_BLANK_ERROR_MSG = "입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw"
    private const val UNSUPPORTED_OPERATOR_MSG = "지원하지 않는 연산자입니다."
    private const val ODD_SIZE_REQUIREMENT_MSG = "문자열 사이즈가 3보다 크거나 같은 기수 이여야 한다"
    private const val INPUT_DELIMITER = " "
    private const val MINIMUM_SIZE = 3

    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { NULL_OR_BLANK_ERROR_MSG }
        val elements = input.split(INPUT_DELIMITER)
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

    private fun validateSize(size: Int) {
        require(size >= MINIMUM_SIZE && size % EVEN_NUMBER_DENOMINATOR != EVEN_NUMBER_REMAINDER) { ODD_SIZE_REQUIREMENT_MSG }
    }

    private fun getFirstValue(elements: List<String>) = elements[FIRST_VALUE_INDEX].toInt()

    private fun getNextValue(it: List<String>, operatorIndex: Int) = it[operatorIndex + OPERAND_OFFSET].toInt()

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
