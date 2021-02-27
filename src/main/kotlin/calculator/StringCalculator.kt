package calculator

class StringCalculator {

    fun calculate(input: String): Int {
        val formula = replace(input).toMutableList().map { it.toString() }
        val leftNumber = formula[0]
        val rightNumber = formula[2]
        return leftNumber.toInt() + rightNumber.toInt()
    }

    private fun replace(s: String) = s.replace(FORMULA_REGEX, EMPTY)

    companion object {
        private val FORMULA_REGEX = "[^\\d+\\-*/]".toRegex()
        private const val EMPTY = ""
    }
}
