package step2

class Validate {
    fun numbers(tokens: List<String>): List<Double> =
        try {
            tokens.filterIndexed { index, _ -> index % 2 == 0 }.map { token -> token.toDouble() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자 형태를 입력해주세요.")
        }

    fun operands(tokens: List<String>): List<Operator> =
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
