package racinggame.view.converter

object NameConverter : InputConverter<List<String>> {
    private const val DELIMITER = ","

    override fun convert(input: String): List<String> {
        return input.split(DELIMITER)
    }
}
