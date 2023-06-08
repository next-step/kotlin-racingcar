package calculator.operation

import java.math.BigDecimal

class MinusOperation(
    private val leftExpression: InfixOperation,
    private val rightExpression: InfixOperation
) : InfixOperation {
    override fun operate(): BigDecimal = leftExpression.operate() - rightExpression.operate()
}
