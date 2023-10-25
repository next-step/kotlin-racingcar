package calculator

import java.lang.IllegalArgumentException

object IntCalculator {
    fun calculate(expression: IntExpression): Int {
        if (expression.operations.isEmpty()) return expression.initialNumber
        return expression.operations.fold(expression.initialNumber) { base, operation ->
            executeOperation(base, operation)
        }
    }

    private fun executeOperation(base: Int, operation: IntExpression.Operation): Int =
        when (operation.operator) {
            Operator.ADD -> add(base, operation.operand)
            Operator.SUBTRACT -> subtract(base, operation.operand)
            Operator.MULTIPLY -> multiply(base, operation.operand)
            Operator.DIVIDE -> divide(base, operation.operand)
        }

    private fun add(base: Int, value: Int): Int = base + value

    private fun subtract(base: Int, value: Int): Int = base - value

    private fun multiply(base: Int, value: Int): Int = base * value

    private fun divide(base: Int, value: Int): Int {
        if (value == 0) throw IllegalArgumentException("0으로 나눌 수는 없습니다")
        return base / value
    }
}
