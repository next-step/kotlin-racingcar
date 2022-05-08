package calculator

object StringCalculator {

    private const val DELIMITER = " "

    fun calculate(expression: String?): Result {
        requireNotNull(expression)
        require(expression.isNotBlank())

        val (operands: List<Operand>, operations: List<Operation>) = tokenize(expression)

        require(operands.size > operations.size)

        return execute(operands = operands, operations = operations)
    }

    private fun tokenize(expression: String): Pair<List<Operand>, List<Operation>> {
        val tokenized = expression.split(DELIMITER)
        val (first, second) = tokenized.withIndex().partition { it.index % 2 == 0 }
        val operands = first.map { Operand.of(it.value) }
        val operations = second.map { Operation.findBySymbol(it.value) }
        return operands to operations
    }

    private fun execute(operands: List<Operand>, operations: List<Operation>): Result {
        val results = operands.toMutableList()
        operations.forEach {
            results.add(0, it.execute(results.removeFirst(), results.removeFirst()))
        }
        return results.first()
    }
}
