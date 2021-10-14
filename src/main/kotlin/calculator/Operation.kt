package calculator

import java.math.BigDecimal

interface Operation {
    fun perform(firstOperand: Operand, secondOperand: Operand): Operand
}
