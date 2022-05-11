package racinggame.view.parser

class NameParser : InputParser<List<String>> {
    override fun parse(input: String): List<String> {
        return input.split(DELIMITER)
    }

    companion object {
        private const val DELIMITER = ","
    }
}