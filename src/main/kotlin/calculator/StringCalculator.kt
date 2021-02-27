package calculator

class StringCalculator {

    fun calculate(input: String): Int {
        val formula = replace(input).toMutableList().map { it.toString() }
        val leftNumber = formula[0].toInt()
        val rightNumber = formula[2].toInt()
        val operator = formula[1]

        return when (operator) {
            "+" -> leftNumber + rightNumber
            "-" -> leftNumber - rightNumber
            "*" -> leftNumber * rightNumber
            else -> throw IllegalArgumentException()
        }
    }

    private fun replace(s: String) = s.replace(FORMULA_REGEX, EMPTY)

    companion object {
        private val FORMULA_REGEX = "[^\\d+\\-*/]".toRegex()
        private const val EMPTY = ""
    }
}
