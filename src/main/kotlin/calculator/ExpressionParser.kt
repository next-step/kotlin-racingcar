package calculator

class ExpressionParser(private val expression: String) {
    init {
        require(expression.isNotBlank()) { IllegalArgumentException("Expression should be not blank") }
    }

    fun getOperators(): List<String> {
        return expression.split(DELIMITER).filterIndexed { index, _ -> index % STEP == OPERATOR_INDEX }
    }

    fun getOperands(): List<String> {
        return expression.split(DELIMITER).filterIndexed { index, _ -> index % STEP == OPERAND_INDEX }
    }

    companion object {
        private const val DELIMITER = " "
        private const val STEP = 2
        private const val OPERATOR_INDEX = 1
        private const val OPERAND_INDEX = 0
    }
}
