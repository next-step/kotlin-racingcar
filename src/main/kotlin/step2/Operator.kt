package step2

enum class Operator(private val symbol: String, private val operator: (Double, Double) -> Double) {
    PLUS("+", { a: Double, b: Double -> a + b }),
    SUBTRACT("-", { a: Double, b: Double -> a - b }),
    MULTIPLY("*", { a: Double, b: Double -> a * b }),
    DIVISION("/", { a: Double, b: Double ->
        @Suppress("UNINITIALIZED_ENUM_COMPANION_WARNING")
        require(b != 0.0) { division0ErrorMessage }
        a / b
    });

    companion object {
        private const val symbolErrorMessage = "지원하지 않는 연산자"
        const val division0ErrorMessage = "0 으로 나눌 수 없습니다."
        fun operatorBy(symbol: String) = when (symbol) {
            PLUS.symbol -> PLUS.operator
            SUBTRACT.symbol -> SUBTRACT.operator
            MULTIPLY.symbol -> MULTIPLY.operator
            DIVISION.symbol -> DIVISION.operator
            else -> throw IllegalAccessError(symbolErrorMessage)
        }
        val symbols = Operator.values().map { it.symbol }
    }
}
