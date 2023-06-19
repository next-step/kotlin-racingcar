package calculator

class Expression(input: Input) {

    private val operands: List<Operand>
    private val operators: List<Operator>

    init {
        val values = input.split(DELIMITER)

        require(values.isOddSize()) { "수식이 올바르지 않습니다. $input" }

        val (operands, operators) = values.parseExpression()
        this.operands = operands
        this.operators = operators

        require(operands.size == operators.size + 1) { "수식이 올바르지 않습니다. $input" }
    }

    fun calculate(): Operand {
        val seed = operands.first()
        return operators
            .zip(operands.drop(1))
            .fold(seed) { acc, (operator, operand) ->
                operator.operate(acc, operand)
            }
    }

    private fun List<*>.isOddSize(): Boolean = this.size % 2 == 1

    private fun IndexedValue<*>.isEven(): Boolean = this.index % 2 == 0

    private fun List<String>.parseExpression(): Pair<List<Operand>, List<Operator>> {
        val (evenIndexed, oddIndexed) = this.withIndex().partition { it.isEven() }
        val operands = evenIndexed.map { Operand(it.value) }
        val operators = oddIndexed.map { Operator.of(it.value) }
        return Pair(operands, operators)
    }

    companion object {
        private const val DELIMITER = " "
    }
}
