package operation

enum class Operator(val symbol: String) {
    SUM("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun from(symbol: String): Operator {
            return entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
