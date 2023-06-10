package calculator

import calculator.operation.InfixOperation
import calculator.operation.NumberOperation
import calculator.operation.Operator

class InfixExpressionParser {
    private val infixExpressionFormatValidator: InfixExpressionFormatValidator = InfixExpressionFormatValidator()

    fun parse(expression: String?): InfixOperation {
        infixExpressionFormatValidator.validateExpressionBlankOrNull(expression)
        expression!!
        infixExpressionFormatValidator.validateExpressionFormat(expression)

        val operands = getOperands(expression)
        val operators = getOperators(expression)

        infixExpressionFormatValidator.validateNumberOfOperands(operands, operators)

        var result: InfixOperation = NumberOperation(operands[0])
        for (i in operators.indices) {
            result = Operator.getOperator(operators[i], result, NumberOperation(operands[i + 1]))
        }

        return result
    }

    private fun getOperators(expression: String): List<String> =
        expression
            .replace("\\d".toRegex(), "")
            .asSequence()
            .map { it.toString() }
            .toList()

    private fun getOperands(expression: String): List<String> =
        expression
            .split("[+\\-*/]".toRegex())
            .asSequence()
            .filter { it.isNotBlank() }
            .toList()
}
