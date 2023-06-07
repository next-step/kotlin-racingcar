package calculator

sealed interface MathElement {

    fun isOperand() = this is Operand

    fun isOperator() = this is Operator
}
