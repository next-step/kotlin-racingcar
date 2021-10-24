package step2.calculator

private const val SEPARATOR = " "
private const val NUMBER_REGEX = "^[+-]?\\d+$"
private const val INVALID_EXPRESSION_ERROR_MESSAGE = " is not valid expression"

fun parseToMathExpression(stringExpression: String): MathExpression {
    assertIsNotBlank(stringExpression)

    try {
        return createMathExpression(stringExpression)
    } catch (exception: Exception) {
        throw IllegalArgumentException(stringExpression + INVALID_EXPRESSION_ERROR_MESSAGE)
    }
}

private fun assertIsNotBlank(stringExpression: String) {
    if (stringExpression.isBlank()) {
        throw IllegalArgumentException(stringExpression + INVALID_EXPRESSION_ERROR_MESSAGE)
    }
}

private fun createMathExpression(stringExpression: String): MathExpression {
    return MathExpression(listOf(), listOf())
}
