package step2

private const val PLUS = "+"
private const val MINUS = "-"
private const val MULTIPLY = "*"
private const val DIVIDE = "/"
private const val OPERAND_OFFSET = 1
private const val FIRST_OPERATOR_INDEX = 1
private const val OPERATOR_GAP = 2
private const val FIRST_VALUE_INDEX = 0
private const val NULL_OR_BLANK_ERROR_MSG = "입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw"
private const val UNSUPPORTED_OPERATOR_MESSAGE = "지원하지 않는 연산자입니다."
private const val INPUT_DELIMITER = " "

class StringCalculator {
    companion object {
        fun calculate(input: String?): Int {
            require(!input.isNullOrBlank()) { NULL_OR_BLANK_ERROR_MSG }
            val elements = input.split(INPUT_DELIMITER)
            return calculate(elements)
        }

        private fun calculate(elements: List<String>): Int {
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

        private fun getFirstValue(elements: List<String>) = elements[FIRST_VALUE_INDEX].toInt()

        private fun getNextValue(it: List<String>, operatorIndex: Int) = it[operatorIndex + OPERAND_OFFSET].toInt()

        private fun applyOperation(currentResult: Int, nextValue: Int, operation: String): Int {
            return when (operation) {
                PLUS -> currentResult + nextValue
                MINUS -> currentResult - nextValue
                MULTIPLY -> currentResult * nextValue
                DIVIDE -> currentResult / nextValue
                else -> throw IllegalArgumentException(UNSUPPORTED_OPERATOR_MESSAGE)
            }
        }
    }
}
