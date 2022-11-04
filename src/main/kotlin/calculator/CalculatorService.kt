package calculator

import java.math.BigDecimal

interface CalculatorService {

    fun plus(a: BigDecimal, b: BigDecimal): BigDecimal

    fun minus(a: BigDecimal, b: BigDecimal): BigDecimal

    fun multiply(a: BigDecimal, b: BigDecimal): BigDecimal

    fun divide(a: BigDecimal, b: BigDecimal): BigDecimal
}
