package calculator

class Operand(val value: Double)
typealias Result = Operand

sealed class Operation(val symbol: String) {
    abstract fun execution(left: Operand, right: Operand): Result

    object Plus : Operation(symbol = "+") {
        override fun execution(left: Operand, right: Operand): Result {
            // TODO: 유효성 검사
            return Result(left.value + right.value)
        }
    }

    object Minus : Operation(symbol = "-") {
        override fun execution(left: Operand, right: Operand): Result {
            // TODO: 유효성 검사
            return Result(left.value - right.value)
        }
    }

    object Multiply : Operation(symbol = "*") {
        override fun execution(left: Operand, right: Operand): Result {
            // TODO: 유효성 검사
            return Result(left.value * right.value)
        }
    }

    object Divide : Operation(symbol = "/") {
        override fun execution(left: Operand, right: Operand): Result {
            // TODO: 유효성 검사
            return Result(left.value / right.value)
        }
    }

    companion object {
        fun findBySymbol(symbol: String): Operation? = when (symbol) {
            Plus.symbol -> Plus
            Minus.symbol -> Minus
            Multiply.symbol -> Multiply
            Divide.symbol -> Divide
            else -> null
        }
    }
}

class StringCalculator {

    fun calculate(expression: String?): Result {
        require(expression != null)
        require(expression.isNotEmpty())

        val (operands: List<Operand>, operations: List<Operation>) = tokenize(expression)

        require(operands.size > operations.size)

        return calculate(operands = operands, operations = operations)
    }

    private fun tokenize(expression: String): Pair<List<Operand>, List<Operation>> {
        val tokenized = expression.split(TOKEN)
        val operands: List<Operand> = tokenized.mapIndexedNotNull { index: Int, s: String ->
            if (index % 2 == 0) Operand(s.toDouble()) else null
        }
        val operations: List<Operation> = tokenized.mapIndexedNotNull() { index: Int, s: String ->
            if (index % 2 != 0) Operation.findBySymbol(s) else null
        }
        return operands to operations
    }

    private fun calculate(operands: List<Operand>, operations: List<Operation>): Result {
        val results = operands.toMutableList()
        operations.forEach {
            results.add(0, it.execution(results.removeFirst(), results.removeFirst()))
        }
        return results.first()
    }

    companion object {
        private const val TOKEN = " "
    }
}
