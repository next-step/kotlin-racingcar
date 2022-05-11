package calculator

const val OPERAND_DIFF_COUNT = 1

class CalculationParameter(expression: String) {
    val operators: List<Operator>
    val operands: List<Int>

    init {
        validateExpression(expression)
        operators = OPERATOR_REGEX.findAll(expression).map {
            Operator.stringOf(it.groupValues[0].trim())
        }.toList()
        operands = OPERATOR_REGEX.split(expression).map {
            convertStringOperand(it)
        }
    }

    private fun convertStringOperand(stringOperand: String): Int {
        val result: Int

        try {
            result = Integer.parseInt(removeSpace(stringOperand))
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ErrorMessage.getParseIntErrorMessage(stringOperand))
        }

        return result
    }

    companion object {
        private val OPERATOR_REGEX = Regex("([+-/*])")
        private val EXPRESSION_REGEX = Regex("([0-9]|[+-/*])+")

        fun validateExpression(arithmeticExpression: String) {
            val trimmedExpression = removeSpace(arithmeticExpression)

            if (trimmedExpression.isEmpty()) {
                throw IllegalArgumentException(ErrorMessage.SPACE_INPUT_ERROR)
            }
            if (!EXPRESSION_REGEX.matches(trimmedExpression)) {
                throw IllegalArgumentException(ErrorMessage.OTHER_STRING_INPUT_ERROR)
            }
            val operatorCount = OPERATOR_REGEX.findAll(trimmedExpression).count()
            val operandCount = OPERATOR_REGEX.split(trimmedExpression).filter { it.isNotEmpty() }.count()
            if (isNotMatchOperatorOperandCount(operatorCount, operandCount)) {
                throw IllegalArgumentException(ErrorMessage.NOT_MATCH_OPERAND_COUNT)
            }
        }

        private fun removeSpace(stringValue: String): String {
            return stringValue.replace("\\s".toRegex(), "")
        }

        private fun isNotMatchOperatorOperandCount(operatorCount: Int, operandCount: Int): Boolean {

            return operatorCount != operandCount - OPERAND_DIFF_COUNT
        }
    }
}
