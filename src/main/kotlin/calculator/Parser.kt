package calculator

class Parser {

    companion object {
        val SPLIT_DELIMITER_REGEX = "\\s+".toRegex()
    }

    fun parse(input: Input): List<String> {
        requireNotNull(input.expression)
        return SPLIT_DELIMITER_REGEX.split(input.expression)
    }
}
