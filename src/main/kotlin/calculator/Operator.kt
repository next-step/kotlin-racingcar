package calculator

import java.math.BigDecimal

enum class Operator(val symbol: String) {
    PLUS("+") {
        override fun operate(left: BigDecimal, right: BigDecimal): BigDecimal {
            return left.plus(right)
        }
    },
    MINUS("-") {
        override fun operate(left: BigDecimal, right: BigDecimal): BigDecimal {
            return left.minus(right)
        }
    },
    MULTIPLY("*") {
        override fun operate(left: BigDecimal, right: BigDecimal): BigDecimal {
            return left.multiply(right)
        }
    },
    DIVIDE("/") {
        override fun operate(left: BigDecimal, right: BigDecimal): BigDecimal {
            return left.divide(right)
        }
    },
    ;

    abstract fun operate(left: BigDecimal, right: BigDecimal): BigDecimal

    companion object {
        fun of(symbol: String): Operator = values().firstOrNull { it.symbol == symbol }
            ?: throw IllegalArgumentException("연산자가 아닙니다.")
    }
}
