package calculator

enum class Operator(val symbol: String) {
    ADDITION("+") {
        override fun calculate(first: Int, second: Int): Int = first.plus(second)
    },
    SUBTRACTION("-") {
        override fun calculate(first: Int, second: Int): Int = first.minus(second)
    },
    MULTIPLICATION("*") {
        override fun calculate(first: Int, second: Int): Int = first.times(second)
    },
    DIVISION("/") {
        override fun calculate(first: Int, second: Int): Int = first.div(second)
    },
    ;

    abstract fun calculate(first: Int, second: Int): Int

    companion object {
        fun valueOfSymbol(symbol: String): Operator = values().find { it.symbol == symbol }
            ?: throw IllegalArgumentException("It is not four basic arithmetic operations")
    }
}
