package calculator

class Calculator {

    companion object {

        private const val DELIMITER = " "
        private const val OPERATOR_REGEX = "^[+\\-*/]+$"
        private const val OPERAND_REGEX = "\\d+"

        fun calculate(expression: String?): Int {
            checkExpression(expression)

            val expressions = splitExpression(expression!!)

            val operands = extractOperands(expressions)
            val operators = extractOperators(expressions)

            return calculate(operands, operators)
        }

        private fun checkExpression(expression: String?) {
            if (expression.isNullOrBlank()) {
                throw IllegalArgumentException("expression is cannot be null or blank")
            }
        }

        private fun splitExpression(expression: String): List<String> {
            return expression.split(DELIMITER)
        }

        private fun extractOperands(expressionList: List<String>): List<String> {
            val operands = expressionList.filterIndexed { index, _ -> index % 2 == 0 }

            checkOperands(operands)

            return operands
        }

        private fun checkOperands(operands: List<String>) {
            val invalidOperand = operands.firstOrNull { !Regex(OPERAND_REGEX).matches(it) }

            if (invalidOperand != null) {
                throw IllegalArgumentException("operand should be number [0-9]")
            }
        }

        private fun extractOperators(expressionList: List<String>): List<String> {
            val operators = expressionList.filterIndexed { index, _ -> index % 2 != 0 }

            checkOperators(operators)

            return operators
        }

        private fun checkOperators(operators: List<String>) {
            val invalidOperator = operators.firstOrNull { !Regex(OPERATOR_REGEX).matches(it) }

            if (invalidOperator != null) {
                throw IllegalArgumentException("not supported operator")
            }
        }

        private fun calculate(operands: List<String>, operators: List<String>): Int {
            return operators.foldIndexed(operands[0].toInt()) { index, acc, _ ->
                val operator = Operator.findBySymbol(operators[index])
                operator.calculate(acc, operands[index + 1].toInt())
            }
        }
    }
}
