package calculator.operation

import java.math.BigDecimal

class DivideOperation(
    private val leftExpression: InfixOperation,
    private val rightExpression: InfixOperation
) : InfixOperation {
    override fun operate(): BigDecimal {
        if (rightExpression.operate() == BigDecimal.ZERO)
            throw ArithmeticException("분모가 0 이 될 수 없습니다.")
        return leftExpression.operate() / rightExpression.operate()
    }
}
