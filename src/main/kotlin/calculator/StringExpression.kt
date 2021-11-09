package calculator

object StringExpression {
    private const val SEPARATOR = " "
    private const val INVALID_EXPRESSION_ERROR_MESSAGE = " is not valid expression"
    private const val ELEMENT_MIN_SIZE = 1
    private const val CHECK_EVEN = 2
    private const val IS_EVEN = 0
    private val NUMBER_REGEX = Regex("^[+-]?\\d+$")

    fun parseToMathExpression(stringExpression: String): MathExpression {
        return runCatching {
            assertIsNotBlank(stringExpression)
            val expressionPieces = stringExpression.trim().split(SEPARATOR)
            assertExpressionPieces(expressionPieces)

            createMathExpression(expressionPieces)
        }.getOrElse {
            throw IllegalArgumentException(stringExpression + INVALID_EXPRESSION_ERROR_MESSAGE)
        }
    }

    private fun assertIsNotBlank(stringExpression: String) {
        if (stringExpression.isBlank()) {
            throw IllegalArgumentException()
        }
    }

    private fun assertExpressionPieces(expressionPieces: List<String>) {
        val expressionPiecesSize = expressionPieces.size

        if (expressionPiecesSize <= ELEMENT_MIN_SIZE || expressionPiecesSize % CHECK_EVEN == IS_EVEN) {
            throw IllegalArgumentException()
        }
    }

    private fun createMathExpression(expressionPieces: List<String>): MathExpression {
        val operandPieces = extractOperandPieces(expressionPieces)

        return MathExpression(
            _operands = generateOperands(operandPieces),
            _operators = generateOperators(expressionPieces, operandPieces)
        )
    }

    private fun extractOperandPieces(expressionPieces: List<String>) = expressionPieces.filter { piece ->
        piece.matches(NUMBER_REGEX)
    }.toList()

    private fun generateOperands(operandPieces: List<String>) =
        operandPieces.map {
            Operand(it.toInt())
        }.toList()

    private fun generateOperators(expressionPieces: List<String>, operandPieces: List<String>) =
        expressionPieces.minus(operandPieces)
            .map {
                Operator.getOperator(it)
            }.toList()
}
