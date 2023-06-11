package calculator

import calculator.operation.InfixOperation
import calculator.operation.NumberOperation
import calculator.operation.Operator

class InfixExpressionParser {
    private val infixExpressionFormatValidator: InfixExpressionFormatValidator = InfixExpressionFormatValidator()

    fun parse(expression: String?): InfixOperation {
        require(expression?.isNotBlank() ?: throw IllegalArgumentException("수식은 null 일 수 없습니다.")) { "수식은 공백 일 수 없습니다." }
        infixExpressionFormatValidator.validateExpressionFormat(expression)

        val operands = Operator.splitOperands(expression).apply(::println)
        val operators = Operator.splitOperators(expression).apply(::println)

        infixExpressionFormatValidator.validateNumberOfOperands(operands, operators)

        var result: InfixOperation = NumberOperation(operands[0])
        for (i in operators.indices) {
            result = Operator.getOperator(operators[i], result, NumberOperation(operands[i + 1]))
        }

        return result
    }
}
