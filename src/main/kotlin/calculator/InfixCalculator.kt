package calculator

import calculator.operation.DivideOperation
import calculator.operation.InfixOperation
import calculator.operation.MinusOperation
import calculator.operation.MultiplyOperation
import calculator.operation.NumberOperation
import calculator.operation.PlusOperation

class InfixCalculator(private val expression: String?) {
    private val infixExpressionFormatValidator: InfixExpressionFormatValidator = InfixExpressionFormatValidator()
    private val infixExpressionFormatter: InfixExpressionFormatter = InfixExpressionFormatter()

    init {
        require(expression?.isBlank() ?: throw IllegalArgumentException("수식은 null 일 수 없습니다.")) { "수식은 공백 일 수 없습니다." }
    }

    fun calculate() = parseExpression().operate()

    private fun parseExpression(): InfixOperation {
        val expressionWithoutSpace = infixExpressionFormatter.eraseWhiteSpace(expression)
        infixExpressionFormatValidator.validateExpressionFormat(expressionWithoutSpace)

        val operands = getOperands(expressionWithoutSpace)
        val operators = getOperators(expressionWithoutSpace)

        infixExpressionFormatValidator.validateNumberOfOperands(operands, operators)

        var result: InfixOperation = NumberOperation(operands[0])
        for (i in operators.indices) {
            result = getOperator(operators[i], result, NumberOperation(operands[i + 1]))
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

    private fun getOperator(
        input: String,
        leftOperation: InfixOperation,
        rightOperation: InfixOperation
    ): InfixOperation =
        when (input) {
            OPS.PLUS.symbol -> PlusOperation(leftOperation, rightOperation)
            OPS.MINUS.symbol -> MinusOperation(leftOperation, rightOperation)
            OPS.TIMES.symbol -> MultiplyOperation(leftOperation, rightOperation)
            OPS.DIV.symbol -> DivideOperation(leftOperation, rightOperation)
            else -> throw IllegalArgumentException("지원 하지 않는 연산자입니다.")
        }
}

enum class OPS(val symbol: String) {
    PLUS("+"), MINUS("-"), TIMES("*"), DIV("/");
}
