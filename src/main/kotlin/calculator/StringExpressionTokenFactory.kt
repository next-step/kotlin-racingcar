package calculator

class StringExpressionTokenFactory {
    fun createStringExpressionOperand(operand: String): StringExpressionOperand {
        return StringExpressionOperand(operand)
    }

    fun createStringExpressionOperator(operator: String): StringExpressionOperator {
        return StringExpressionOperator(operator)
    }
}
