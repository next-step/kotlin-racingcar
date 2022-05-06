package step2

sealed class Operation(
    val symbol: String
) {
    abstract fun execute(x1: Int, x2: Int): Int

    object Plus : Operation(symbol = "+") {
        override fun execute(x1: Int, x2: Int): Int {
            return x1 + x2
        }
    }

    object Minus : Operation(symbol = "-") {
        override fun execute(x1: Int, x2: Int): Int {
            return x1 - x2
        }
    }

    object Multiply : Operation(symbol = "*") {
        override fun execute(x1: Int, x2: Int): Int {
            return x1 * x2
        }
    }

    object Divide : Operation(symbol = "/") {
        override fun execute(x1: Int, x2: Int): Int {
            requireNotZero(x1)
            requireNotZero(x2)
            return x1 / x2
        }
    }

    companion object {
        fun of(symbol: String): Operation = when (symbol) {
            Plus.symbol -> Plus
            Minus.symbol -> Minus
            Multiply.symbol -> Multiply
            Divide.symbol -> Divide
            else -> throw IllegalArgumentException()
        }
    }
}
