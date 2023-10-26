package study.calculator

object StringCalculator {
    fun calculate(input: String?): String {
        return input
            .validateNotNullOrBlank()
            .tokenize()
            .preprocess()
            .map { it.recognize() }
            .fold(0) { result, expression -> expression.operator.evaluate(result, expression.number) }
            .toString()
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
