package calculator.operator

enum class OperatorSymbol(private val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun getOperatorSymbol(symbol: String): OperatorSymbol {
            return values().firstOrNull { it.symbol == symbol } ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
