package step2.calculator

object StringCalculator {
    fun execute(input: String?): Double {
        val parsedInput = parseInput(input)

        return calculateInput(parsedInput)
    }

    private fun parseInput(input: String?): List<String> {
        return InputParser.parse(input)
    }

    private fun calculateInput(parsedInput: List<String>): Double {
        var result: Double = parsedInput[0].toDouble()

        for (i in 1 until parsedInput.size step 2) {
            val prev = result
            val operator = Operator.find(parsedInput[i])
            val next = parsedInput[i + 1].toDouble()

            result = Expression(prev, operator, next).calculate()
        }

        return result
    }
}
