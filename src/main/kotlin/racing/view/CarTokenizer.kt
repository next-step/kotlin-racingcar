package racing.view

class CarTokenizer {
    companion object {
        fun tokenize(input: String): ArrayDeque<String> {
            return ArrayDeque(
                input.split(",")
            )
        }
    }
}
