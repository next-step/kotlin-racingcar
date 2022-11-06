package calculator

class Expression(
    expression: String?
) {
    init {
        requireNotNull(expression)
        requireNotBlank(expression)
    }

    private fun requireNotBlank(expression: String) {
        require(expression.isNotBlank())
    }
}
