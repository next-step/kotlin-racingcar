package stringcalculator

enum class Operator(
    private val operatorSign: String,
    private val operation: (Int, Int)
    -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    TIMES("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        if (b == 0) {
            throw IllegalArgumentException("Division by zero is not allowed")
        }
        a / b
    });

    private fun calculate(a: Int, b: Int): Int = operation(a, b)

    companion object {
        fun executeOperation(operatorSign: String, a: Int, b: Int): Int {
            val operator = values().find { it.operatorSign == operatorSign }
                ?: throw IllegalArgumentException("Invalid operator: $operatorSign")

            return operator.calculate(a, b)
        }
    }
}