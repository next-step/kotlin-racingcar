package calculator.operator

import calculator.operand.Operand

object PlusOperator : Operator {
    override fun operate(left: Operand, right: Operand): Operand {
        return left + right
    }
}
