package study.calculation

import java.lang.IllegalArgumentException

class ExpressionToken(
    var operators: MutableList<String> = mutableListOf(),
    val operands: MutableList<Int> = mutableListOf()
) {
    fun addOperator(oper: String) {
        operators.add(Operator.select(oper).oper)
    }

    fun addOperand(operand: Int) {
        operands.add(operand)
    }
}
