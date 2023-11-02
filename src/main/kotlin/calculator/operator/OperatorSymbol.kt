package calculator.operator

enum class OperatorSymbol(private val symbol: String, private val operator: Operator) {
    PLUS("+", PlusOperator),
    MINUS("-", MinusOperator),
    MULTIPLY("*", MultiplyOperator),
    DIVIDE("/", DivideOperator)
    ;

    companion object {

        fun getOperator(symbol: String): Operator =
            values().filter {
                it.symbol == symbol
            }.map {
                it.operator
            }.firstOrNull() ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
    }
}
