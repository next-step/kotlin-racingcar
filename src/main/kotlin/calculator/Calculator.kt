package calculator

import java.math.BigDecimal

class Calculator {
    fun calculate(expression: String): BigDecimal {
        return Expression.from(expression).getResult()
    }
}
