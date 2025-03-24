package calculator

import calculator.exceptions.NumberSeparationException

enum class Operation(
    private val sign: String,
) {
    ADD("+") {
        override fun apply(
            a: Double,
            b: Double,
        ) = a + b
    },
    SUBTRACT("-") {
        override fun apply(
            a: Double,
            b: Double,
        ) = a - b
    },
    MULTIPLY("*") {
        override fun apply(
            a: Double,
            b: Double,
        ) = a * b
    },
    DIVIDE("/") {
        override fun apply(
            a: Double,
            b: Double,
        ) = a / b
    },
    ;

    abstract fun apply(
        a: Double,
        b: Double,
    ): Double

    companion object {
        fun parseOperation(inputOperation: String) =
            Operation.entries.firstOrNull { it.sign == inputOperation }
                ?: throw NumberSeparationException()
    }
}
