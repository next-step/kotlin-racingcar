package calculator.operation

import java.math.BigDecimal

interface InfixOperation {
    fun operate(): BigDecimal
}
