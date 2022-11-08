package calculator

import calculator.SplitUtil.splitExpression

class Calculator(
    private val expression: Expression
) {

    val result get() = calculate(splitExpression(expression))

    private fun calculate(expressionContents: List<String>): Int {
        validateExpression(expressionContents)

        var result = expressionContents.first().toInt()

        for (index in 1 until expressionContents.size step 2) {
            val operator = Operator.of(expressionContents[index])

            val currentOperand = result
            val nextOperand = expressionContents[index + 1].toInt()

            val calculateValue = operator.calculate(currentOperand, nextOperand)
            result = calculateValue
        }

        return result
    }

    private fun validateExpression(expressionContents: List<String>) {
        validateEmptyExpression(expressionContents)

        for (index in 0 until expressionContents.size step 2) {
            runCatching { expressionContents[index].toInt() }
                .onFailure {
                    throw IllegalArgumentException("숫자와 연산자만 입력이 가능합니다.")
                }
        }
    }

    private fun validateEmptyExpression(expressionContents: List<String>) {
        if (expressionContents.isEmpty()) throw IllegalArgumentException("수식이 없습니다.")
    }

}