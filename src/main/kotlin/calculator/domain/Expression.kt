package calculator.domain

import calculator.exception.InvalidExpressionException

class Expression(
    private val value: String?,
) {
    companion object {
        private const val DELIMITER = " "
    }

    init {
        if (value.isNullOrBlank()) {
            throw InvalidExpressionException()
        }
    }

    fun segregateExpressions(): List<String> {
        return value?.split(DELIMITER) ?: emptyList()
    }
}
