package calculator

class StringCalculator {
    companion object {
        fun execute(input: String?): Double {
            val mathematicsElements = parseInput(input)

            return calculateInput(mathematicsElements)
        }
        private fun parseInput(input: String?): List<String> {
            return InputParser.parse(input)
        }

        private fun calculateInput(mathematicsElements: List<String>): Double {
            var result: Double = mathematicsElements[0].toDouble()

            for (i in 1 until mathematicsElements.size step 2) {
                val prevNumber = result
                val operator = Operator.find(mathematicsElements[i])
                val nextNumber = mathematicsElements[i + 1].toDouble()

                result = operator.calculate(prevNumber, nextNumber)
            }

            return result
        }
    }
}
