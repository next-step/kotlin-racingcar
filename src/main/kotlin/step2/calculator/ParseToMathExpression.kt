package step2.calculator

private const val SEPARATOR = " "
private const val NUMBER_REGEX = "^[+-]?\\d+$"
private const val INVALID_EXPRESSION_ERROR_MESSAGE = " is not valid expression"
private const val ELEMENT_MIN_SIZE = 1
private const val CHECK_EVEN = 2
private const val IS_EVEN = 0

fun parseToMathExpression(stringExpression: String): MathExpression {
    try {
        assertIsNotBlank(stringExpression)

        val expressionPieces = stringExpression.trim().split(SEPARATOR)
        assertExpressionPieces(expressionPieces)

        return createMathExpression(expressionPieces)
    } catch (exception: Exception) {
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
    return MathExpression(listOf(), listOf())
}
