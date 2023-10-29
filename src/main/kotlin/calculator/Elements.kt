package calculator

data class Elements(
    val operands: List<Operand>,
    val operators: List<Operator>,
) {
    companion object {
        private const val DELIMITER = " "

        fun of(input: String): Elements {
            return this.of(input, DELIMITER)
        }

        fun of(input: String, delimiter: String): Elements {
            val elements = input.split(delimiter)

            val operands = elements.filterIndexed { index, _ -> index % 2 == 0 }.map { Operand.of(it) }
            val operators = elements.filterIndexed { index, _ -> index % 2 == 1 }.map { Operator.of(it) }

            if (operands.size != operators.size + 1) {
                throw IllegalArgumentException("입력값이 올바르지 않습니다")
            }
            return Elements(operands, operators)
        }
    }

    fun calculate(): Int {
        var result = operands[0].value
        for (i in operators.indices) {
            result = operators[i].calculate(result, operands[i + 1].value)
        }
        return result
    }
}
