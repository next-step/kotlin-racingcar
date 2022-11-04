package calculator

import java.math.BigDecimal

class Calculator {
    companion object : CalculatorService {
        override fun plus(a: BigDecimal, b: BigDecimal): BigDecimal = a.plus(b)

        override fun minus(a: BigDecimal, b: BigDecimal): BigDecimal = a.minus(b)

        override fun multiply(a: BigDecimal, b: BigDecimal): BigDecimal = a.multiply(b)

        override fun divide(a: BigDecimal, b: BigDecimal): BigDecimal = a.divide(b)
    }
}
