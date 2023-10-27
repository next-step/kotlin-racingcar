package calculator

class StringCalculator {
    companion object {
        private const val DELIMITER = " "
        private const val PLUS = "+"
        private const val MINUS = "-"
        private const val MULTIPLY = "*"
        private const val DIVIDE = "/"

        fun calculate(expression: String?): Int {
            val tokens = StringExpression
                .validate(expression)
                .split(DELIMITER)

            val firstNumber = tokens
                .first()
                .toInt()

            return tokens
                .drop(1)
                .chunked(2)
                .fold(firstNumber) { acc, cur ->
                    applyOperation(
                        number1 = acc,
                        number2 = cur[1].toInt(),
                        operator = cur[0]
                    )
                }
        }

        private fun applyOperation(number1: Int, number2: Int, operator: String): Int {
            return when (operator) {
                PLUS -> number1 + number2
                MINUS -> number1 - number2
                MULTIPLY -> number1 * number2
                DIVIDE -> number1 / number2
                else -> throw IllegalArgumentException("unknown operation type.")
            }
        }
    }
}
