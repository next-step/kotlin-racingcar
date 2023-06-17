package calculrate

enum class Operator(val char: String) {
    PLUS("+") {
        override fun operation(first: Int, second: Int): Int = first + second
    },
    MINUS("-") {
        override fun operation(first: Int, second: Int): Int = first - second
    };

    abstract fun operation(first: Int, second: Int): Int

    companion object {
        fun of(symbol: String): Operator {
            val operator = values().firstOrNull { it.char == symbol }
            require(operator != null) {
                "사칙연산 기호가 아닌 경우"
            }
            return operator
        }
    }
}
