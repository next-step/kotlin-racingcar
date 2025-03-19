package calculator

class ExpressionParser(private val expression: String) {
    init {
        require(expression.isNotBlank()) { IllegalArgumentException("Expression should be not blank") }
    }

    fun getOperators(): List<String> {
        val operators = expression.split(DELIMITER).filterIndexed { index, _ -> index % STEP == OPERATOR_INDEX }
        operators.find { !Operator.contains(it) }?.let { nonOperator ->
            throw IllegalArgumentException("Invalid Operator: $nonOperator")
        }
        return operators
    }

    fun getOperands(): List<Int> {
        return expression
            .split(DELIMITER)
            .filterIndexed { index, _ -> index % STEP == OPERAND_INDEX }
            .map { it.toInt() }
    }

    companion object {
        private const val DELIMITER = " "
        private const val STEP = 2
        private const val OPERATOR_INDEX = 1
        private const val OPERAND_INDEX = 0
    }
}
