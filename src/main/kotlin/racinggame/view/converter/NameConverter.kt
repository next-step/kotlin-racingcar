package racinggame.view.converter

class NameConverter : InputConverter<List<String>> {
    override fun convert(input: String): List<String> {
        return input.split(DELIMITER)
    }

    companion object {
        private const val DELIMITER = ","
    }
}
