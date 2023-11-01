package calculator

import calculator.type.Operator
import calculator.validator.OperationValidator

object Calculator {
    fun calculate(expression: String): Int {
        val expressions: List<String> = extract(expression)

        var result = expressions[0].toInt()
        for (index in 1 until expressions.size step 2) {
            val operator = Operator.of(expressions[index])
            if (operator != Operator.NONE) {
                val rightOperand = expressions.getOrNull(index + 1)?.toIntOrNull() ?: continue
                result = operator.operate(result, rightOperand)
            }
        }

        return result
    }

    private fun extract(expression: String): List<String> {
        val expressionList = expression.split(" ")
        require(OperationValidator.hasValidSize(expressionList)) { "잘못된 입력입니다." }
        return expressionList
    }
}
