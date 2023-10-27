package calculator

class StringCalculator {
    fun calculate(input: String?): Int {
        validate(input)
        val removeSpaceInput = input!!.replace(" ", "")

        val numbers =
            removeSpaceInput.split(OPERATOR_REGEX).filter { it.isNotBlank() }.map { it.toInt() }.toMutableList()
        val operators = removeSpaceInput.split(NUMBER_REGEX).filter { it.isNotBlank() }.map { it.single() }
            .mapNotNull { Operator.from(it) }.toMutableList()

        if (numbers.size != operators.size + 1) {
            throw IllegalArgumentException()
        }

        var result = numbers[0]
        for ((index, operator) in operators.withIndex()) {
            result = calculate(operator, result, numbers[index + 1])
        }
        return result
    }

    private fun validate(input: String?) {
        if (input.isNullOrBlank() || hasNotArithmeticOperator(input)) {
            throw IllegalArgumentException()
        }
    }

    private fun hasNotArithmeticOperator(input: String) = !EXPRESSION_REGEX.matches(input)

    private fun calculate(operator: Operator, left: Int, right: Int) = operator.operate(left, right)

    companion object {
        private val EXPRESSION_REGEX = "[0-9+\\-*/\\s]+".toRegex()
        private val NUMBER_REGEX = "[0-9]+".toRegex()
        private val OPERATOR_REGEX = "[+\\-*/]".toRegex()
    }
}
