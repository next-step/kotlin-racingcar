package calculator.calculator.domain

private const val DELIMITER = " "

class Expression(input: String) {
    private var numbers: List<Double>
    private var operators: List<Operator>

    init {
        val tokens = input.split(DELIMITER)
        validate(tokens)

        numbers = toNumbers(tokens)
        operators = toOperators(tokens)
    }

    private fun validate(tokens: List<String>) {
        require(tokens.size % 2 != 0) { "항의 개수를 잘못 입력하셨습니다." }
    }

    private fun isNumber(index: Int) = index % 2 == 0

    private fun isOperator(index: Int) = index % 2 != 0

    private fun toNumbers(tokens: List<String>): List<Double> {
        try {
            return tokens.filterIndexed { index, token -> isNumber(index) }
                .map { token -> token.toDouble() }
                .toList()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자를 잘못 입력하셨습니다.")
        }
    }

    private fun toOperators(tokens: List<String>) = tokens.filterIndexed { index, token -> isOperator(index) }
        .map { token -> Operator.from(token) }
        .toList()

    fun getResult(): Double {
        var prev = numbers[0]
        for (i in operators.indices) {
            val operator = operators[i]
            val next = numbers[i + 1]
            prev = operator.calculate(prev, next)
        }
        return prev
    }
}
