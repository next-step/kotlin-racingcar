package calculator

import calculator.SplitUtil.splitExpression

class Expression(
    val inputs: String
) {

    init {
        validateExpression(splitExpression(this))
    }

    fun addOperand(input: String): Expression {
        return Expression("$inputs $input")
    }

    fun addOperator(input: String): Expression {
        val operator = Operator.of(input)
        return Expression("$inputs ${operator.operator}")
    }

    private fun validateExpression(expressionContents: List<String>) {
        println(expressionContents.size)
        validateEmptyExpression(expressionContents)
        validateNumber(expressionContents)
        validateOperator(expressionContents)
    }

    private fun validateEmptyExpression(expressionContents: List<String>) {
        if (expressionContents.isEmpty()) throw IllegalArgumentException("수식이 없습니다.")
    }

    private fun validateNumber(expressionContents: List<String>) {
        for (index in INDEX_FIRST_OPERAND until expressionContents.size step STEP_OPERAND) {
            runCatching { expressionContents[index].toInt() }
                .onFailure {
                    throw IllegalArgumentException("숫자와 연산자만 입력이 가능합니다.")
                }
        }
    }

    private fun validateOperator(expressionContents: List<String>) {
        for (index in INDEX_FIRST_OPERATOR until expressionContents.size step STEP_OPERATOR) {
            Operator.of(expressionContents[index])
        }
    }

    companion object {
        private const val INDEX_FIRST_OPERAND = 0
        private const val STEP_OPERAND = 2

        private const val INDEX_FIRST_OPERATOR = 1
        private const val STEP_OPERATOR = 2
    }

}