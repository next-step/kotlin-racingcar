package racing.view

class CarTokenizer {

    companion object {
        private const val DELIMITER = ","

        fun tokenize(input: String): ArrayDeque<String> {
            return ArrayDeque(
                input.split(DELIMITER)
            )
        }
    }
}
