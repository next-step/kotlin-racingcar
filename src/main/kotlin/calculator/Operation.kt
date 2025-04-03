package calculator

import calculator.exceptions.NumberSeparationException

enum class Operation(
    private val sign: String,
    val apply: (Double, Double) -> Double,
) {
    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> if (b == 0.0) throw ArithmeticException("Division by zero") else a / b }),
    ;

    companion object {
        fun from(inputOperation: String) =
            Operation.entries.firstOrNull { it.sign == inputOperation }
                ?: throw NumberSeparationException()
    }
}
