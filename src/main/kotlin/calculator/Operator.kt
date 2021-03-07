package calculator

enum class Operator(val value: String, val operate: (a: Operand, b: Operand) -> Scalar) {
    ADD("+", { a, b -> Scalar(a.value + b.value) }),
    SUBTRACT("-", { a, b -> Scalar(a.value - b.value) }),
    MULTIPLY("*", { a, b -> Scalar(a.value * b.value) }),
    DIVIDE("/", { a, b -> Scalar(a.value / b.value) });

    companion object {
        private val operators = values().associateBy { it.value }

        fun parse(value: String): Operator {
            return requireNotNull(operators[value]) {
                "The value is not operator, value='$value'"
            }
        }
    }
}
