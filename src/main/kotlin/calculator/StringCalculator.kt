package calculator

class StringCalculator {
    fun calculate(input: String?): Int {
        validate(input)
        val removeSpaceInput = input!!.replace(" ", "")

        val numbers =
            removeSpaceInput.split(Operator.OPERATOR_REGEX).filter { it.isNotBlank() }.map { it.toInt() }
        val operators = removeSpaceInput.split(NUMBER_REGEX).filter { it.isNotBlank() }.map { it.single() }
            .mapNotNull { Operator.from(it) }

        if (numbers.size != operators.size + 1) {
            throw IllegalArgumentException("계산할 수 없는 문자열입니다. input=$input, 숫자=${numbers.size}, 연산자=${operators.size}")
        }

        var result = numbers[0]
        for ((index, operator) in operators.withIndex()) {
            result = calculate(operator, result, numbers[index + 1])
        }
        return result
    }

    private fun validate(input: String?) {
        require(!input.isNullOrBlank()) { "입력값은 null이거나 빈 문자열일 수 없습니다." }
        require(hasArithmeticOperator(input)) { "입력값은 사칙연산만을 허용합니다." }
    }

    private fun hasArithmeticOperator(input: String) = EXPRESSION_REGEX.matches(input)

    private fun calculate(operator: Operator, left: Int, right: Int) = operator.operate(left, right)

    companion object {
        private val EXPRESSION_REGEX = "[0-9+\\-*/\\s]+".toRegex()
        private val NUMBER_REGEX = "[0-9]+".toRegex()
    }
}
