package calculator

import java.math.BigDecimal

class Calculator {

    fun add(x: BigDecimal, y: BigDecimal): BigDecimal = x.add(y)

    fun subtract(x: BigDecimal, y: BigDecimal): BigDecimal = x.subtract(y)

    fun divide(x: BigDecimal, y: BigDecimal): BigDecimal = x.divide(y)

    fun multiply(x: BigDecimal, y: BigDecimal): BigDecimal = x.multiply(y)
}
