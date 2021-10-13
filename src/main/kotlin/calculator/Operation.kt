package calculator

import java.math.BigDecimal

interface Operation {
    fun perform(firstOperand: BigDecimal, secondOperand: BigDecimal): BigDecimal
}
