package racing.view

object CarTokenizer {

    private const val DELIMITER = ","

    fun tokenize(input: String): ArrayDeque<String> {
        return ArrayDeque(
            input.split(DELIMITER)
        )
    }
}
