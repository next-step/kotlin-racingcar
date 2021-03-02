package calculator

enum class Operator(val value: String) {
    ADD("+") {
        override fun operate(a: Operand, b: Operand) = Scalar(a.value + b.value)
    },
    SUBTRACT("-") {
        override fun operate(a: Operand, b: Operand) = Scalar(a.value - b.value)
    },
    MULTIPLY("*") {
        override fun operate(a: Operand, b: Operand) = Scalar(a.value * b.value)
    },
    DIVIDE("/") {
        override fun operate(a: Operand, b: Operand) = Scalar(a.value / b.value)
    };

    abstract fun operate(a: Operand, b: Operand): Scalar

    companion object {
        private val operators = values().associateBy { it.value }

        fun parse(value: String): Operator {
            return operators[value] ?: throw IllegalArgumentException("The value is not operator, value='$value'")
        }
    }
}
