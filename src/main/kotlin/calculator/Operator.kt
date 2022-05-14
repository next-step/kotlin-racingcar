package calculator

enum class Operator(val symbol: String, val expression: (number1: Number, number2: Number) -> Number) {
    PLUS(symbol = "+", expression = { number1: Number, number2: Number -> number1.plus(number2) }),
    MINUS(symbol = "-", expression = { number1: Number, number2: Number -> number1.minus(number2) }),
    MULTIPLE(symbol = "*", expression = { number1: Number, number2: Number -> number1.multiply(number2) }),
    DIVISION(symbol = "/", expression = { number1: Number, number2: Number -> number1.divide(number2) }), ;

    fun calculate(number1: Number, number2: Number): Number {
        return this.expression(number1, number2)
    }

    companion object {
        fun of(value: String): Operator {
            return values().firstOrNull { it.symbol == value }
                ?: throw IllegalArgumentException("지원하지 않는 연산자 입니다. operator: $value")
        }
    }
}
