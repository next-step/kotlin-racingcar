package step2

import step2.tokenize.DefaultTokenizer
import step2.tokenize.Tokenize

class Calculate {
    private val DELIMITER = " "
    private val validate = Validate()
    private val tokenize: Tokenize = DefaultTokenizer()

    operator fun invoke(equation: String): Double {
        require(equation.isBlank().not()) { "공식은 빈값이 될 수 없습니다." }
        val tokens = tokenize(equation, DELIMITER)
        require(tokens.size % 2 != 0) { "올바른 항의 갯수를 입력해주세요." }
        val numbers = validate.numbers(tokens)
        val operands = validate.operands(tokens)
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
}
