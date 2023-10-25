package calculator

enum class Operation(val operation: String) {
    PLUS("+") {
        override fun apply(currentValue: Int, operand: Int): Int = currentValue.plus(operand)
    },
    MINUS("-") {
        override fun apply(currentValue: Int, operand: Int): Int = currentValue.minus(operand)
    },
    MULTIPLY("*") {
        override fun apply(currentValue: Int, operand: Int): Int = currentValue.times(operand)
    },
    DIVIDE("/") {
        override fun apply(currentValue: Int, operand: Int): Int = currentValue.div(operand)
    };

    abstract fun apply(currentValue: Int, operand: Int): Int
}
