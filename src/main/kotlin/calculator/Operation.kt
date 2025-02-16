package calculator

enum class Operation(val symbol: String) {
    ADD("+") {
        override fun apply(
            a: Int,
            b: Int,
        ) = a + b
    },
    SUBTRACT("-") {
        override fun apply(
            a: Int,
            b: Int,
        ) = a - b
    },
    MULTIPLY("*") {
        override fun apply(
            a: Int,
            b: Int,
        ) = a * b
    },
    DIVIDE("/") {
        override fun apply(
            a: Int,
            b: Int,
        ): Int {
            require(b != 0) { "0으로 나눌 수 없습니다." }
            return a / b
        }
    },
    ;

    abstract fun apply(
        a: Int,
        b: Int,
    ): Int

    companion object {
        fun from(symbol: String): Operation {
            return entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("알 수 없는 연산자가 있습니다.: $symbol")
        }
    }
}
