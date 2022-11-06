package calculator

import java.math.BigDecimal

/**
 * 계산 연산자
 */
enum class Operator(val symbol: String) {

    PLUS("+") {
        override fun operate(a: BigDecimal, b: BigDecimal): BigDecimal = a.add(b)
    },
    MINUS("-") {
        override fun operate(a: BigDecimal, b: BigDecimal): BigDecimal = a.minus(b)
    },
    MULTIPLY("*") {
        override fun operate(a: BigDecimal, b: BigDecimal): BigDecimal = a.multiply(b)
    },
    DIVIDE("/") {
        override fun operate(a: BigDecimal, b: BigDecimal): BigDecimal {
            require(b != BigDecimal.ZERO) { "0으로 나눌 수 없습니다." }
            return a.divide(b)
        }
    };

    abstract fun operate(a: BigDecimal, b: BigDecimal): BigDecimal

    companion object {
        fun of(symbol: String): Operator {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
