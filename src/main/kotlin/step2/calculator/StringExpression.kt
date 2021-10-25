package step2.calculator

object StringExpression {
    private const val SEPARATOR = " "
    private const val INVALID_EXPRESSION_ERROR_MESSAGE = " is not valid expression"
    private const val ELEMENT_MIN_SIZE = 1
    private const val CHECK_EVEN = 2
    private const val IS_EVEN = 0
    private val NUMBER_REGEX = Regex("^[+-]?\\d+$")

    fun parseToMathExpression(stringExpression: String): MathExpression {
        val result = runCatching {
            assertIsNotBlank(stringExpression)
            val expressionPieces = stringExpression.trim().split(SEPARATOR)
            assertExpressionPieces(expressionPieces)

            createMathExpression(expressionPieces)
        }.onSuccess {
            return it
        }.onFailure {
            throw IllegalArgumentException(stringExpression + INVALID_EXPRESSION_ERROR_MESSAGE)
        }

        return result.getOrThrow()
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
        val operands = mutableListOf<Operand>()
        val operators = mutableListOf<Operator>()

        for (piece in expressionPieces) {
            extractElement(piece, operands, operators)
        }

        return MathExpression(
            _operands = operands,
            _operators = operators
        )
    }

    private fun extractElement(element: String, operands: MutableList<Operand>, operators: MutableList<Operator>) {
        if (element.matches(NUMBER_REGEX)) {
            operands.add(Operand(element.toInt()))
            return
        }

        operators.add(Operator.getOperator(element))
    }
}
