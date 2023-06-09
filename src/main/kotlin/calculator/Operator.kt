package calculator

enum class Operator(private val s: String) {
    PLUS("+") {
        override fun operation(x: Int, y: Int) = x + y
    },
    MINUS("-") {
        override fun operation(x: Int, y: Int) = x - y
    },
    MULTIPLY("*") {
        override fun operation(x: Int, y: Int) = x * y
    },
    DIVIDE("/") {
        override fun operation(x: Int, y: Int) = x / y
    };

    abstract fun operation(x: Int, y: Int): Int

    companion object {
        fun of(symbol: String): Operator {
            val operator = values().find { it.s == symbol }
            require(operator != null) {
                "사칙연산 기호가 아닌 경우"
            }
            return operator
        }
    }
}
