package calculator

class StringCalculator {

    fun calculate(input: String): Int {
        validate(input)

        val formula = replace(input).toMutableList().map { it.toString() }

        val operators = IntRange(1, formula.size - 1)
            .step(2)
            .map { formula[it] }

        val numbers = IntRange(0, formula.size - 1)
            .step(2)
            .map { formula[it].toInt() }

        var result = numbers[0]

        for (i in operators.indices) {
            result = calculate(result, operators[i], numbers[i + 1])
        }

        return result
    }

    private fun replace(s: String) = s.replace(FORMULA_REGEX, EMPTY)

    private fun calculate(leftNumber: Int, operator: String, rightNumber: Int): Int {
        return when (operator) {
            "+" -> leftNumber + rightNumber
            "-" -> leftNumber - rightNumber
            "*" -> leftNumber * rightNumber
            "/" -> {
                if (rightNumber == 0) {
                    throw IllegalArgumentException()
                }
                leftNumber / rightNumber
            }
            else -> throw IllegalArgumentException()
        }
    }

    private fun validate(input: String) {
        if (input.isBlank() || hasNotFormulaSymbol(input)) {
            throw IllegalArgumentException()
        }
    }

    private fun hasNotFormulaSymbol(input: String) = FORMULA_REGEX.containsMatchIn(input)

    companion object {
        private val FORMULA_REGEX = "[^\\d+\\-*/]".toRegex()
        private const val EMPTY = ""
    }
}
