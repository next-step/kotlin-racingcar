package calculator

enum class Operator(val symbol: String) : (Double, Double) -> Double {
    ADDITION("+") {
        override fun invoke(number1: Double, number2: Double): Double = number1.plus(number2)
    },
    SUBTRACTION("-") {
        override fun invoke(number1: Double, number2: Double): Double = number1.minus(number2)
    },
    DIVISION("/") {
        override fun invoke(number1: Double, number2: Double): Double {
            require(number2 != 0.0) { "나눗셈 피연산자는 0이 될 수 없어요." }
            return number1.div(number2)
        }
    },
    MULTIPLICATION("*") {
        override fun invoke(number1: Double, number2: Double): Double = number1.times(number2)
    };

    companion object {
        fun from(symbol: String): Operator =
            Operator.values().find { it.symbol == symbol }
                ?: throw throw IllegalArgumentException("$symbol 에 해당하는 연산자가 존재하지 않습니다.")

        fun exist(symbol: String): Boolean = Operator.values().any { it.symbol == symbol }
    }
}
