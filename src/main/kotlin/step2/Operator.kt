package step2

enum class Operator(val symbol: String) {
    ADD("+") {
        override fun execute(operand1: Int, operand2: Int): Int = operand1 + operand2
    },
    SUBTRACT("-") {
        override fun execute(operand1: Int, operand2: Int): Int = operand1 - operand2
    },
    MULTIPLY("*") {
        override fun execute(operand1: Int, operand2: Int): Int = operand1 * operand2
    },
    DIVIDE("/") {
        override fun execute(operand1: Int, operand2: Int): Int = operand1 / operand2
    };

    companion object {
        fun bySymbol(symbol: String): Operator? {
            return Operator.values().find { it.symbol == symbol }
        }
    }
    abstract fun execute(operand1: Int, operand2: Int): Int
}
