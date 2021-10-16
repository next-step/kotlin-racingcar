package step2

enum class OperatorType(val symbol: String, val operator: Operator) {
    MINUS("-", Operator { a, b -> a - b }),
    PLUS("+", Operator { a, b -> a + b }),
    DIVIDE("/", Operator { a, b ->
        if (b == 0.0)
            throw kotlin.IllegalArgumentException("Can not divided by zero")
        a / b
    }),
    MULTIPLY("*", Operator { a, b -> a * b });

    companion object {
        fun getOperator(symbol: String): Operator {
            val type = values().find { it.symbol == symbol } ?: throw IllegalArgumentException("Not operator symbol!")
            return type.operator
        }
    }
}
