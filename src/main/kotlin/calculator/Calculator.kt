package calculator

class Calculator {
    fun run(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
        }


        val inputs = input?.split(" ")

        val operand = inputs?.filterIndexed { index, s -> index % 2 == 0 }?.map { it.toInt() } ?: emptyList()
        val op = inputs?.filterIndexed { index, s -> index % 2 == 1 }?.map { Operator.from(it) } ?: emptyList()

        return op.foldIndexed(operand[0]) { index, acc, o ->
            val value = operand[index + 1]
            return@foldIndexed calculate(o, acc, value)
        }
    }

    private fun calculate(op: Operator?, acc: Int, value: Int): Int {
        return when (op) {
            Operator.PLUS -> acc + value
            Operator.MINUS -> acc - value
            Operator.MULTIPLY -> acc * value
            Operator.DIVIDE -> acc / value
            else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }
    }
}
