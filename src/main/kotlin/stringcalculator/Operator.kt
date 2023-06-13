package stringcalculator

enum class Operator(
    private val operatorSign: String,
    private val operation: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    TIMES("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        require(b == 0) { "Division by zero is not allowed" }
        a / b
    });

    companion object {
        fun findBy(operatorSign: String): Operator {
            return values().find { it.operatorSign == operatorSign }
                ?: throw IllegalArgumentException("Invalid operator: $operatorSign")
        }
    }

    fun calculate(a: Int, b: Int): Int {
        return operation(a, b)
    }
}