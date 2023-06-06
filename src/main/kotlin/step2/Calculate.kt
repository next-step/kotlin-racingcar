package step2

class Calculate {
    private val DELIMITER = " "

    operator fun invoke(equation: String): Double {
        require(equation.isBlank().not()) { "공식은 빈값이 될 수 없습니다." }
        val tokens = tokenize(equation)
        require(tokens.size % 2 != 0) { "올바른 항의 갯수를 입력해주세요." }
        val numbers = validateNumbers(tokens)
        val operands = validateOperand(tokens)
        return calculate(numbers, operands)
    }

    private fun calculate(numbers: List<Double>, operator: List<Operator>): Double {
        var answer = numbers[0]
        operator.forEachIndexed { index, operator ->
            val secondNumber = numbers[index + 1]
            answer = calculateOperand(answer, secondNumber, operator)
        }
        return answer
    }

    private fun calculateOperand(firstNumber: Double, secondNumber: Double, operand: Operator): Double =
        when (operand) {
            Operator.DIVIDE -> firstNumber / secondNumber
            Operator.MULTIPLY -> firstNumber * secondNumber
            Operator.PLUS -> firstNumber + secondNumber
            Operator.MINUS -> firstNumber - secondNumber
        }

    private fun tokenize(equation: String): List<String> = equation.split(DELIMITER)

    private fun validateNumbers(tokens: List<String>): List<Double> =
        try {
            tokens.filterIndexed { index, _ -> index % 2 == 0 }.map { token -> token.toDouble() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자 형태를 입력해주세요.")
        }

    private fun validateOperand(tokens: List<String>): List<Operator> =
        tokens.filterIndexed { index, _ -> index % 2 != 0 }.map { token -> compareOperand(token) }

    private fun compareOperand(operand: String): Operator =
        when (operand) {
            "+" -> Operator.PLUS
            "-" -> Operator.MINUS
            "*" -> Operator.MULTIPLY
            "/" -> Operator.DIVIDE
            else -> throw IllegalArgumentException("올바른 계산자를 입력해주세요.")
        }
}

enum class Operator(val operand: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");
}
