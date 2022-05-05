package calculator

object StringCalculator {

    private const val DELIMITER = " "

    fun calculate(expression: String?): Result {
        require(expression != null)
        require(expression.isNotBlank())

        val (operands: List<Operand>, operations: List<Operation>) = tokenize(expression)

        require(operands.size > operations.size)

        return execute(operands = operands, operations = operations)
    }

    private fun tokenize(expression: String): Pair<List<Operand>, List<Operation>> {
        val tokenized = expression.split(DELIMITER)
        val operands: List<Operand> = tokenized.mapIndexedNotNull { index: Int, s: String ->
            if (index % 2 == 0) Operand.of(s) else null
        }
        val operations: List<Operation> = tokenized.mapIndexedNotNull() { index: Int, s: String ->
            if (index % 2 != 0) Operation.findBySymbol(s) else null
        }
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
