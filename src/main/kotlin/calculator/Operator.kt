package calculator

enum class Operator(private val symbol: String, val operate: (Operand, Operand) -> Operand) {

    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        private val operatorMap: Map<String, Operator> = values().associateBy { it.symbol }
        fun of(symbol: String): Operator = operatorMap[symbol] ?: throw IllegalArgumentException("'$symbol'는 지원하지 않는 연산자 입니다.")
    }
}
