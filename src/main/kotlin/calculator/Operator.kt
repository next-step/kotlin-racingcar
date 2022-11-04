package calculator

sealed interface Operator {

    fun operate(num1: Double, num2: Double): Double

    object Plus : Operator {
        override fun operate(num1: Double, num2: Double): Double =
            num1.plus(num2)
    }

    object Minus : Operator {
        override fun operate(num1: Double, num2: Double): Double =
            num1.minus(num2)
    }

    object Multiply : Operator {
        override fun operate(num1: Double, num2: Double): Double =
            num1.times(num2)
    }

    object Divide : Operator {
        override fun operate(num1: Double, num2: Double): Double =
            num1.div(num2)
    }

    companion object {
        operator fun invoke(symbol: String): Operator = when (symbol) {
            SYMBOL_PLUS -> Plus
            SYMBOL_MINUS -> Minus
            SYMBOL_MULTIPLY -> Multiply
            SYMBOL_DIVIDE -> Divide
            else -> throw IllegalArgumentException()
        }

        private const val SYMBOL_PLUS = "+"
        private const val SYMBOL_MINUS = "-"
        private const val SYMBOL_MULTIPLY = "*"
        private const val SYMBOL_DIVIDE = "/"

        const val OPERATORS = "*+-/"
    }
}