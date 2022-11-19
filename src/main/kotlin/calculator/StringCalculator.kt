package calculator

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
            val prevNumber = result
            val operator = Operator.find(parsedInput[i])
            val nextNumber = parsedInput[i + 1].toDouble()

            result = operator.calculate(prevNumber, nextNumber)
        }

        return result
    }
}
