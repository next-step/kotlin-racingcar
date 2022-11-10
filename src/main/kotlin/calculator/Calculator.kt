package calculator

import calculator.SplitUtil.splitExpression


class Calculator(
    private val expression: Expression
) {

    val result = calculate()

    private fun calculate(): Int {
        val expressionContents = splitExpression(expression)

        var result = expressionContents.first().toInt()

        for (index in INDEX_FIRST_OPERATOR until expressionContents.size step STEP_OPERATOR) {
            val operator = Operator.of(expressionContents[index])

            val currentOperand = result
            val indexNextOperand = index + 1

            val nextOperand = expressionContents[indexNextOperand].toInt()
            val calculateValue = operator.calculate(currentOperand, nextOperand)

            result = calculateValue
        }

        return result
    }

    companion object {
        private const val INDEX_FIRST_OPERATOR = 1
        private const val STEP_OPERATOR = 2
    }

}