package calculator

class Calculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
        }

        val inputs = input.split(" ")

        val operand = inputs.filterIndexed { index, s -> index % 2 == 0 }.map { it.toInt() }
        val operator = inputs.filterIndexed { index, s -> index % 2 == 1 }.map { Operator.of(it) }

        return operator.foldIndexed(operand[0]) { index, acc, op ->
            val value = operand[index + 1]
            when (op) {
                Operator.PLUS -> acc + value
                Operator.MINUS -> acc - value
                Operator.MULTIPLY -> acc * value
                Operator.DIVIDE -> acc / value
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }
    }
}
