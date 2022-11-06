package calculator

class Input(
    private val expression: String?
) {
    init {
        requireNotNull(expression)
        requireNotBlank(expression)
        requireValidExpression(expression)
    }

    companion object {
        val regex = Regex("[0-9+-\\/*\\s]+")
    }

    private fun requireNotBlank(expression: String) {
        require(expression.isNotBlank())
    }

    private fun requireValidExpression(expression: String) {
        require(regex.matches(expression))
    }
}
