package calculator.view

class ConsoleInput {

    companion object {
        private const val DELIMITER = " "
    }

    fun readExpression(): List<String> {
        return readLine()?.also { if (it.isBlank()) throw IllegalArgumentException("empty string is not allowed") }
            ?.run { split(DELIMITER) }
            ?: throw IllegalArgumentException("null is not allowed")
    }
}
