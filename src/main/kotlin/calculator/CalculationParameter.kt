package calculator

class CalculationParameter {
    var operators: List<String> = emptyList<String>()
    var operands: List<Int> = emptyList<Int>()

    constructor(expression: String?) {
        if (expression == null) throw IllegalArgumentException(ErrorMessage.NULL_INPUT_ERROR)
        validateExpression(expression)

        operators = OPERATOR_REGEX.findAll(expression).toList().map {
            it.groupValues[0]
        }.toList()

        operands = OPERATOR_REGEX.split(expression).map {
            convertStringOperand(it)
        }
    }

    private fun convertStringOperand(stringOperand: String): Int {
        var result: Int

        try {
            result = Integer.parseInt(spaceRemove(stringOperand))
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ErrorMessage.getParseIntErrorMessage(stringOperand))
        }

        return result
    }

    private fun spaceRemove(stringValue: String): String {
        return stringValue.replace("\\s".toRegex(), "")
    }

    fun validateExpression(arithmeticExpression: String) {
        val trimmedExpression = spaceRemove(arithmeticExpression)

        if (trimmedExpression.length === 0) throw IllegalArgumentException(ErrorMessage.SPACE_INPUT_ERROR)
        if (!EXPRESSION_REGEX.matches(trimmedExpression)) throw IllegalArgumentException(ErrorMessage.OTHER_STRING_INPUT_ERROR)
        val operatorCount = OPERATOR_REGEX.findAll(trimmedExpression).toList().size
        val operandCount = OPERATOR_REGEX.split(trimmedExpression).filter { it.isNotEmpty() }.size
        if (isNotMatchOperatorOperandCount(operatorCount, operandCount)) throw IllegalArgumentException(ErrorMessage.NOT_MATCH_OPERAND_COUNT)
    }

    private fun isNotMatchOperatorOperandCount(operatorCount: Int, operandCount: Int): Boolean {
        return operatorCount !== operandCount - 1
    }

    companion object {
        private val OPERATOR_REGEX = Regex("([+-/*])")
        private val EXPRESSION_REGEX = Regex("([0-9]|[+-/*])+")
    }
}
