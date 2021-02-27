package calculator

class StringCalculator {

    fun calculate(input: String): Int {
        val formula = replace(input).toMutableList().map { it.toString() }
        val leftNumber = formula[0].toInt()
        val rightNumber = formula[2].toInt()
        val operator = formula[1]

        if (operator == "+") {
            return leftNumber + rightNumber
        }

        if (operator == "*") {
            return leftNumber * rightNumber
        }

        return leftNumber - rightNumber
    }

    private fun replace(s: String) = s.replace(FORMULA_REGEX, EMPTY)

    companion object {
        private val FORMULA_REGEX = "[^\\d+\\-*/]".toRegex()
        private const val EMPTY = ""
    }
}
