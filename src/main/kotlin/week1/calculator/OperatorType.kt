package week1.calculator

enum class OperatorType(
    val value: String,
) : OperatorExecutor {
    ADD("+") {
        override fun execute(a: Int, b: Int) = a + b
    },
    SUBTRACT("-") {
        override fun execute(a: Int, b: Int) = a - b
    },
    MULTIPLY("*") {
        override fun execute(a: Int, b: Int) = a * b
    },
    DIVIDE("/") {
        override fun execute(a: Int, b: Int): Int {
            return if (b == 0) {
                a
            } else {
                a / b
            }
        }
    },
    ;

    companion object {
        fun from(value: String): OperatorType? {
            return OperatorType.values().firstOrNull { it.value == value }
        }

        fun isOperatorSymbol(symbol: String): Boolean {
            val type = OperatorType.from(symbol) ?: return false
            return OperatorType.values().contains(type)
        }
    }
}