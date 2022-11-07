package calculator

import java.math.BigDecimal

enum class Operator(val operator: String) {

    PLUS("+") {
        override fun apply(a: BigDecimal, b: BigDecimal): BigDecimal = a.plus(b)
    },
    MINUS("-") {
        override fun apply(a: BigDecimal, b: BigDecimal): BigDecimal = a.minus(b)
    },
    MULTIPLY("*") {
        override fun apply(a: BigDecimal, b: BigDecimal): BigDecimal = a.multiply(b)
    },
    DIVIDE("/") {
        override fun apply(a: BigDecimal, b: BigDecimal): BigDecimal {
            if ("0".toBigDecimal() == b) throw IllegalArgumentException("0으로 나눌 수 없음")
            return a.divide(b)
        }
    };

    abstract fun apply(a: BigDecimal, b: BigDecimal): BigDecimal

    companion object {
        fun calculate(a: BigDecimal, b: BigDecimal, operator: String): BigDecimal =
            values().find { it.operator == operator }
                ?.apply(a, b) ?: throw IllegalArgumentException("연산자 없음")
    }
}
