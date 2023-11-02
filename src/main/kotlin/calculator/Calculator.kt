package calculator

import calculator.operand.Operand
import calculator.operator.OperatorSymbol

object Calculator {

    fun calculate(expressions: List<String>): Operand {
        validateExpression(expressions)

        if (expressions.size == 1) {
            return Operand.of(expressions[0])
        }

        val initialResult = operate(expressions.subList(0, 3))

        return expressions.drop(3)
            .chunked(2)
            .fold(initialResult) { result, expression ->
                operate(listOf(result.toString()) + expression)
            }
    }

    private fun validateExpression(expressions: List<String>) {
        require(expressions.size % 2 != 0) { "수식이 올바르지 않습니다." }
    }

    private fun operate(expressions: List<String>): Operand {
        val leftOperand = Operand.of(expressions[0])
        val operatorSymbol = expressions[1]
        val rightOperand = Operand.of(expressions[2])

        val targetOperator = OperatorSymbol.getOperator(operatorSymbol)
        return targetOperator.operate(leftOperand, rightOperand)
    }
}
