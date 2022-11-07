package step2

class StringCalculator {

    fun execute(input: String): Int {
        if (input.isBlank()) {
            throw StringCalculatorIllegalArgumentException()
        }

        val values = parse(input)
        var result = values.first().toInt()

        values.forEachIndexed { index, s ->
            if (index == values.size - 1) return@forEachIndexed

            val operand = values[index + 1].toIntOrNull() ?: return@forEachIndexed

            val operator: Operator = when (s) {
                "+" -> Adder(result, operand)
                "-" -> Subtractor(result, operand)
                "*" -> Multiplier(result, operand)
                "/" -> Divider(result, operand)
                else -> throw StringCalculatorIllegalArgumentException()
            }

            result = operator.calculate()
        }

        return result
    }

    companion object {
        fun parse(input: String): List<String> {
            validate(input)
            return input.split(" ")
        }

        private fun validate(value: String): String {
            val regex = Regex("^(\\d+ [+\\-*/] )+\\d+\$")

            if (!regex.containsMatchIn(value)) {
                throw StringCalculatorIllegalArgumentException()
            }

            return value
        }
    }
}
