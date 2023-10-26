package step2

object StringCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("input must not be blank")
        }

        val tokens = tokenize(input)
        return calculateByIterator(tokens)
    }

    private fun tokenize(input: String): List<String> {
        val tokens = input.trim().split(" ")
        if (tokens.size % 2 == 0) {
            throw IllegalArgumentException("invalid input")
        }

        return tokens
    }

    private fun calculateByIterator(tokens: List<String>): Int {
        var sum = tokens[0].toInt()
        for (i in 1 until tokens.size step 2) {
            when (tokens[i]) {
                "+" -> sum += tokens[i + 1].toInt()
                "-" -> sum -= tokens[i + 1].toInt()
                "*" -> sum *= tokens[i + 1].toInt()
                "/" -> sum /= tokens[i + 1].toInt()
                else -> throw IllegalArgumentException("invalid operator")
            }
        }

        return sum
    }
}
