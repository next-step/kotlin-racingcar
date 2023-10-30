package calculator

import calculator.type.Operator
import calculator.validator.OperationValidator

class Calculator {
    fun calculate(expression: String): Int {
        val expressionList = extractExpressionList(expression)

        var result = expressionList[0].toInt()
        for (index in 1 until expressionList.size step 2) {
            val operator = Operator.of(expressionList[index])
            if (operator != Operator.NONE) {
                val rightOperand = expressionList.getOrNull(index + 1)?.toIntOrNull() ?: continue
                result = performOperation(result, rightOperand, operator)
            }
        }

        return result
    }

    private fun extractExpressionList(expression: String): List<String> {
        val expressionList = expression.split(" ")
        if (OperationValidator.hasValidSize(expressionList).not()) throw IllegalArgumentException("잘못된 입력입니다.")
        return expressionList
    }

    private fun performOperation(left: Int, right: Int, operator: Operator): Int {
        return operator.operationFunction(left, right)
    }
}
