package calculator

class ArithmeticCalculator {

    @Throws(
        IllegalArgumentException::class,
        NumberFormatException::class
    )
    fun execute(text: String?): Double {
        return calculate(
            text.orEmpty()
                .split(" ")
                .filter { it.isNotBlank() }
        )
    }

    @Throws(
        IllegalArgumentException::class,
        NumberFormatException::class
    )
    private fun calculate(input: List<String>): Double {
        require(input.size >= 3) {
            "It must consist of at least two numbers and one operator."
        }
        require(input.size % 2 == 1) {
            "The number of input strings must be odd. ex) \"1 + 2\" -> [1], [+], [2]"
        }
        return input.drop(1)
            .chunked(2)
            .map { (maybeOperator, maybeNumber) -> ArithmeticOperator.of(maybeOperator) to maybeNumber.toDouble() }
            .fold(input.first().toDouble()) { current, (operator, next) -> operator.execute(current, next) }
    }
}
