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

    companion object {
        fun findBySymbol(symbol: String): Operation? = when (symbol) {
            Plus.symbol -> Plus
            else -> null
        }
    }
}

class StringCalculator {

    fun calculate(expression: String): Result {

        val tokenized = expression.split(" ")
        val operands: MutableList<Operand> = tokenized.mapIndexedNotNull { index: Int, s: String ->
            if (index % 2 == 0) Operand(s.toDouble()) else null
        }.toMutableList()
        val operations: List<Operation> = tokenized.mapIndexedNotNull() { index: Int, s: String ->
            if (index % 2 != 0) Operation.findBySymbol(s) else null
        }

        operations.forEach {
            val result = it.execution(operands.removeFirst(), operands.removeFirst())
            operands.add(0, result)
        }

        return operands.removeFirst()
    }

}
