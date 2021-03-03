package study.step2

import java.lang.IllegalArgumentException

data class ExpressionToken(
    var operators: MutableList<String> = mutableListOf(),
    val operands: MutableList<Int> = mutableListOf()
) {
    fun addOperator(operator: String) {
        when (operator) {
            "+", "-", "*", "/" -> operators.add(operator)
            else -> throw IllegalArgumentException("지원하는 연산자가 아닙니다.")
        }
    }

    fun addOperand(operand: Int) {
        operands.add(operand)
    }
}
