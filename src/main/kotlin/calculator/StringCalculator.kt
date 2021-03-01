package calculator

class StringCalculator {

    fun calculate(input: String): Int {
        validate(input)

        val numbers = input.split(OPERATOR_REGEX).map { it.toInt() }
        val symbols = input.split(NUMBER_REGEX).filter { it.isNotBlank() }

        if (numbers.size != symbols.size + 1) {
            throw IllegalArgumentException()
        }

        var result = numbers[0]

        for (i in symbols.indices) {
            result = calculate(result, symbols[i], numbers[i + 1])
        }

        return result
    }

    private fun validate(input: String) {
        if (input.isBlank() || hasNotFormulaSymbol(input)) {
            throw IllegalArgumentException()
        }
    }

    private fun hasNotFormulaSymbol(input: String) = FORMULA_REGEX.containsMatchIn(input)

    private fun calculate(leftNumber: Int, symbol: String, rightNumber: Int): Int {
        val operator = Operator.find(symbol)
        return operator.apply(leftNumber, rightNumber)
    }

    companion object {
        private val FORMULA_REGEX = "[^\\d+\\-*/]".toRegex()
        private val OPERATOR_REGEX = "[+\\-*/]".toRegex()
        private val NUMBER_REGEX = "[0-9]+".toRegex()
    }
}
