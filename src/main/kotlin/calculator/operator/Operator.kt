package calculator.operator

import calculator.operand.Operand

interface Operator {
    fun operate(left: Operand, right: Operand): Double
    fun canHandle(operator: String): Boolean
}
