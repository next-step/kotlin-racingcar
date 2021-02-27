package calculator

class StringCalculator {

    fun calculate(input: String): Int {
        val formula = replace(input).toMutableList().map { it.toString() }
        val leftNumber = formula[0].toInt()
        val rightNumber = formula[2].toInt()
        val operator = formula[1]

        return calculate(leftNumber, operator, rightNumber)
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

    companion object {
        private val FORMULA_REGEX = "[^\\d+\\-*/]".toRegex()
        private const val EMPTY = ""
    }
}
