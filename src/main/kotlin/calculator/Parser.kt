package calculator

class Parser {

    companion object {
        private val regex = Regex("\\s+")
    }

    fun parse(input: Input): List<String> {
        requireNotNull(input.expression)
        return regex.split(input.expression)
    }
}
