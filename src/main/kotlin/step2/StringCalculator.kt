package step2

class StringCalculator {

    fun execute(input: String): Int {
        if (input.isBlank()) {
            throw InvalidCalculatorInput()
        }

        val values = parse(input)
        var result = values.first().toInt()

        values.forEachIndexed { index, symbol ->
            if (index == values.size - 1) return@forEachIndexed

            val operand = values[index + 1].toIntOrNull() ?: return@forEachIndexed

            val operator = Operation.symbolToOperator(symbol)

            result = operator.calculate(result, operand)
        }

        return result
    }

    companion object {
        private val regex = Regex("^(\\d+ [+\\-*/] )+\\d+\$")

        fun parse(input: String): List<String> {
            validate(input)
            return input.split(" ")
        }

        private fun validate(value: String): String {
            if (!regex.containsMatchIn(value)) {
                throw InvalidCalculatorInput()
            }

            return value
        }
    }
}
