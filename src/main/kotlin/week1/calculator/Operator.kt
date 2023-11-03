package week1.calculator

enum class Operator(
    val value: String,
    private val executor: OperatorExecutor,
) {
    ADD("+", OperatorExecutor { a, b -> a + b }),
    SUBTRACT("-", OperatorExecutor { a, b -> a - b }),
    MULTIPLY("*", OperatorExecutor { a, b -> a * b }),
    DIVIDE("/", OperatorExecutor { a, b -> a / b }),
    ;

    fun execute(a: Int, b: Int) = executor.execute(a, b)

    companion object {
        fun from(symbol: String): Operator {
            return Operator.values().firstOrNull { it.value == symbol } ?: throw IllegalArgumentException()
        }

        fun isOperatorSymbol(symbol: String): Boolean {
            return values().any { it.value == symbol }
        }
    }
}
