package calculator.domain

data class Expression(
    val operands: List<Operand>,
    val operators: List<Operator>
) {
    init {
        require(operands.size == operators.size + 1) { "유효하지 않은 식입니다" }
    }

    companion object {
        private val REMOVE_BLANK_REGEX = """\p{Blank}""".toRegex()
        private val OPERAND_REGEX = """[^\d\p{LC}]""".toRegex()
        private val OPERATOR_REGEX = """[\d\p{LC}]""".toRegex()

        fun of(input: String): Expression {
            val blankRemovedInput = input.replace(REMOVE_BLANK_REGEX, "")
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
