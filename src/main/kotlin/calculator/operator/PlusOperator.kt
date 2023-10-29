package calculator.operator

import calculator.operand.Operand

object PlusOperator : Operator {
    override fun operate(left: Operand, right: Operand): Double {
        return (left + right)
    }

    override fun canHandle(operator: String): Boolean {
        return OperatorSymbol.isPlus(operator)
    }
}
