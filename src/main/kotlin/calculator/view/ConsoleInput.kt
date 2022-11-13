package calculator.view

class ConsoleInput {

    fun readExpression(): List<String> {
        return readln().ifBlank { throw IllegalArgumentException("empty string is not allowed") }
            .split(DELIMITER)
    }

    companion object {
        private const val DELIMITER = " "
    }
}
