package racingcar.calculator

import java.util.function.BinaryOperator

enum class Operator(val symbol: String) : BinaryOperator<Double> {
    PLUS("+") {
        override fun apply(
            x: Double,
            y: Double,
        ): Double = x + y
    },
    MINUS("-") {
        override fun apply(
            x: Double,
            y: Double,
        ): Double = x - y
    },
    MULTIPLE("*") {
        override fun apply(
            x: Double,
            y: Double,
        ): Double = x * y
    },
    DIVIDE("/") {
        override fun apply(
            x: Double,
            y: Double,
        ): Double = x / y
    }, ;

    companion object {
        fun getOperatorBySymbol(symbol: String): Operator {
            return entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("입력하신 문자열은 허용하지 않는 문자열입니다: $symbol")
        }
    }
}
