package calculator

class Parser {

    fun parse(expression: Expression): List<String> {
        requireNotNull(expression.expression)
        return SPLIT_DELIMITER_REGEX.split(expression.expression)
    }

    companion object {
        private val SPLIT_DELIMITER_REGEX = "\\s+".toRegex()
    }
}
