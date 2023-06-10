package step2

enum class Operator(
    private val value: String,
    private val operation: (Operand, Operand) -> Operand
) {

    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    fun operate(operand1: Operand, operand2: Operand): Operand {
        return operation.invoke(operand1, operand2)
    }

    companion object {
        fun from(token: String): Operator? {
            return Operator.values().find {
                it.value == token
            }
        }
    }
}
