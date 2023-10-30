package calculator.operator

import calculator.operand.Operand

sealed interface Operator {
    fun operate(left: Operand, right: Operand): Operand
}
