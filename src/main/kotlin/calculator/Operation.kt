package calculator

typealias Result = Operand

sealed class Operation(val symbol: String) {
    abstract fun execute(left: Operand, right: Operand): Result

    object Plus : Operation(symbol = "+") {
        override fun execute(left: Operand, right: Operand): Result =
            Result(left.value + right.value)
    }

    object Minus : Operation(symbol = "-") {
        override fun execute(left: Operand, right: Operand): Result =
            Result(left.value - right.value)
    }

    object Multiply : Operation(symbol = "*") {
        override fun execute(left: Operand, right: Operand): Result =
            Result(left.value * right.value)
    }

    object Divide : Operation(symbol = "/") {
        override fun execute(left: Operand, right: Operand): Result {
            require(left.value != 0.0 && right.value != 0.0)
            return Result(left.value / right.value)
        }
    }

    companion object {
        fun findBySymbol(symbol: String): Operation = when (symbol) {
            Plus.symbol -> Plus
            Minus.symbol -> Minus
            Multiply.symbol -> Multiply
            Divide.symbol -> Divide
            else -> throw IllegalArgumentException()
        }
    }
}
