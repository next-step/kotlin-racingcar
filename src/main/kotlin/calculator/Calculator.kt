package calculator

import calculator.operand.Operand
import calculator.operator.DivideOperator
import calculator.operator.MinusOperator
import calculator.operator.MultiplyOperator
import calculator.operator.OperatorSymbol
import calculator.operator.PlusOperator

object Calculator {

    private val operators = mapOf(
        OperatorSymbol.PLUS to PlusOperator,
        OperatorSymbol.MINUS to MinusOperator,
        OperatorSymbol.MULTIPLY to MultiplyOperator,
        OperatorSymbol.DIVIDE to DivideOperator
    )

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

        val targetSymbol = OperatorSymbol.getOperatorSymbol(operatorSymbol)
        val targetOperator = operators[targetSymbol] ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        return targetOperator.operate(leftOperand, rightOperand)
    }
}
