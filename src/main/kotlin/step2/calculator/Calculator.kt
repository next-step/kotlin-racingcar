package step2.calculator

import step2.calculator.utils.CustomStringParser

class Calculator {

    fun calculate(input: String): Long {
        val strings = CustomStringParser.parse(input)
        val token = CustomStringParser.removeEmptyStrings(strings)

        return _calculate(token)
    }

    private fun _calculate(token: List<String>): Long {
        val operator = getOperator(token)
        val (first, second) = Pair(token[FIRST_NUMBER_POSITION_INDEX], token[SECOND_NUMBER_POSITION_INDEX])

        return operator.operate(first, second)
    }

    private fun getOperator(token: List<String>): Operator {
        return Operator.getOperator(token[OPERATOR_POSITION_INDEX])
    }

    companion object {
        private const val OPERATOR_POSITION_INDEX = 1

        private const val FIRST_NUMBER_POSITION_INDEX = 0
        private const val SECOND_NUMBER_POSITION_INDEX = 2
    }
}
