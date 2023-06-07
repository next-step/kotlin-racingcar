package stringcalculator

private const val OPERATOR_REGEX = "[+\\-*/]"

private const val NUMBER_REGEX = "\\d+"

class StringCalculator {
    companion object {
        fun calculate(input: String?): Int {
            require(!input.isNullOrBlank())
            require(input.contains(Regex(OPERATOR_REGEX)))

            val numbers = input.split(Regex(OPERATOR_REGEX)).map { it.toInt() }
            val operators = input.split(Regex(NUMBER_REGEX)).filter { it.isNotEmpty() }

            require(numbers.size == operators.size + 1)

            var result = numbers[0]
            for (i in operators.indices) {
                when (operators[i]) {
                    "+" -> result += numbers[i + 1]
                    "-" -> result -= numbers[i + 1]
                    "*" -> result *= numbers[i + 1]
                    "/" -> result /= numbers[i + 1]
                }
            }
            return result
        }
    }
}
