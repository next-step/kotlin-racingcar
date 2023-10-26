package study.calculator

object StringCalculator {
    fun calculate(input: String?): String {
        var result: Int = 0
        input
            .validateNotNullOrBlank()
            .tokenize()
            .preprocess()
            .map { it.recognize() }
            .forEach { result = it.evaluate(result) }
        return result.toString()
    }

    private fun String?.validateNotNullOrBlank() = takeUnless { isNullOrBlank() }
        ?: throw IllegalArgumentException("Input value cannot be null or blank")

    private fun String.tokenize() = split(' ')

    private fun List<String>.preprocess() =
        takeIf { size % 2 != 0 }
            ?.let { listOf<String>("+", *it.toTypedArray()) }
            ?.chunked(2)
            ?: throw IllegalArgumentException("Invalid number of tokens")

    private fun List<String>.recognize() = Expression(this[0], this[1])
}
