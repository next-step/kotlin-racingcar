package calculator.expression

class StringExpression(
    expression: String?
) {
    private val expression: String

    init {
        require(!expression.isNullOrBlank()) {
            "expression is null or blank."
        }

        validateFormat(expression)

        this.expression = expression
    }

    companion object {
        private const val DELIMITER = " "
        private val formatRegex = """^[0-9]+(?: [+\-*/] [0-9]+)*$""".toRegex()
    }

    fun tokenize(): List<String> {
        return expression.split(DELIMITER)
    }

    private fun validateFormat(expression: String) {
        if (!formatRegex.matches(expression)) throw IllegalArgumentException("invalid expression format.")
    }
}
