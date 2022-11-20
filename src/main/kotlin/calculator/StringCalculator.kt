package calculator

class StringCalculator {
    companion object {
        private const val CALCULATE_START_INDEX = 1
        private const val CALCULATE_UNIT_SIZE = 2

        fun execute(input: String?): Double {
            val mathematicsElements = parseToMathematicsElement(input)

            return calculateMathematicsElement(mathematicsElements)
        }
        private fun parseToMathematicsElement(input: String?): List<String> {
            return InputParser.parse(input)
        }

        private fun calculateMathematicsElement(mathematicsElements: List<String>): Double {
            var calculateResult: Double = mathematicsElements[0].toDouble()

            for (i in CALCULATE_START_INDEX until mathematicsElements.size step CALCULATE_UNIT_SIZE) {
                val operator = Operator.find(mathematicsElements[i])
                val nextCalculateNumber = mathematicsElements[i + 1].toDouble()

                calculateResult = operator.calculate(calculateResult, nextCalculateNumber)
            }

            return calculateResult
        }
    }
}
