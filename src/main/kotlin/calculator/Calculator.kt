package calculator

import calculator.StringExpression.parseToMathExpression

object Calculator {
    private const val ARITHMETIC_EXCEPTION_ERROR_MESSAGE = "Error occurred during calculate"

    fun calculate(expression: String): Int {
        val mathExpression = parseToMathExpression(expression)

        return kotlin.runCatching {
            calculate(mathExpression)
        }.getOrElse {
            throw ArithmeticException(ARITHMETIC_EXCEPTION_ERROR_MESSAGE)
        }
    }

    private fun calculate(mathExpression: MathExpression): Int {
        var result: Int = mathExpression.operands[0].value

        repeat(mathExpression.operatorsSize) {
            val operator: Operator = mathExpression.operators[it]
            val operand: Operand = mathExpression.operands[it + 1]

            result = elementCalculate(operator, result, operand.value)
        }

        return result
    }

    private fun elementCalculate(operator: Operator, firstOperand: Int, secondOperand: Int): Int {
        return operator.calculate(firstOperand, secondOperand)
    }
}
