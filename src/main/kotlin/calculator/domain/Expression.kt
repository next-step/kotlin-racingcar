package calculator.domain

data class Expression(
    val operands: List<Operand>,
    val operators: List<Operator>
) {
    init {
        if (operands.size != operators.size + 1) {
            throw IllegalStateException("유효하지 않은 식입니다")
        }
    }

    companion object {
        private val OPERAND_REGEX = """[\+\-*/]""".toRegex()
        private val OPERATOR_REGEX = """\d+""".toRegex()

        fun of(input: String): Expression {
            val blankRemovedInput = input.replace(" ", "")
            val operands = blankRemovedInput.split(OPERAND_REGEX)
                .filter { it.isNotBlank() }
                .map { Operand.of(it) }
            val operators = blankRemovedInput.split(OPERATOR_REGEX)
                .filter { it.isNotBlank() }
                .map { Operator.of(it) }
            return Expression(operands, operators)
        }
    }
}
