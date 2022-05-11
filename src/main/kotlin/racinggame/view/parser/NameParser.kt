package racinggame.view.parser

class NameParser : InputParser<String, List<String>> {
    override fun parse(input: String): List<String> {
        return input.split(DELIMITER)
    }

    companion object {
        private const val DELIMITER = ","
    }
}