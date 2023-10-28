package calculator

import calculator.operand.Operand
import calculator.operator.OperatorFactory

object Calculator {

    fun calculate(expressions: List<String>): Double {
        validateExpression(expressions)

        if (expressions.size == 1) {
            validateNumber(expressions[0])
            return expressions[0].toDouble()
        }

        val result = operate(expressions)
        if (expressions.size == 3) {
            return result
        }

        return calculate(listOf(result.toString()) + expressions.drop(3))
    }

    private fun validateExpression(expressions: List<String>) {
        require(expressions.size % 2 != 0) { "수식이 올바르지 않습니다." }
    }

    private fun validateNumber(expression: String): Double {
        return expression.toDoubleOrNull() ?: throw IllegalArgumentException("수식의 개수가 1개면 숫자만 입력할 수 있습니다.")
    }

    private fun operate(expressions: List<String>): Double {
        val leftOperand = Operand.of(expressions[0])
        val operatorSymbol = expressions[1]
        val rightOperand = Operand.of(expressions[2])

        val operator = OperatorFactory.findOperator(operatorSymbol)
        return operator.operate(leftOperand, rightOperand)
    }
}
