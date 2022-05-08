package step2.calculator

import step2.calculator.utils.CustomStringParser

class Calculator {

    fun calculate(input: String?): Double {
        val words = CustomStringParser.splitAsWords(input)
        val token = CustomStringParser.removeEmptyStrings(words)

        return _calculate(token)
    }

    private fun _calculate(token: List<String>): Double {
        val numberPair = getNumberPair(token)
        val operator = getOperator(token)

        val result = operator.operate(numberPair)

        if (hasNextOperation(token)) {
            val leftToken: List<String> = token.subList(NEXT_OPERATOR_START_INDEX, token.size)
            return _calculate(listOf(result.toString()) + leftToken)
        }
        return result
    }

    private fun hasNextOperation(token: List<String>): Boolean {
        return token.size > NEXT_OPERATOR_START_INDEX
    }

    private fun getNumberPair(token: List<String>): NumberPair {
        return NumberPair.of(token[FIRST_NUMBER_POSITION_INDEX], token[SECOND_NUMBER_POSITION_INDEX])
    }

    private fun getOperator(token: List<String>): Operator {
        return Operator.findOperator(token[OPERATOR_POSITION_INDEX])
    }

    companion object {
        private const val OPERATOR_POSITION_INDEX = 1

        private const val FIRST_NUMBER_POSITION_INDEX = 0
        private const val SECOND_NUMBER_POSITION_INDEX = 2

        private const val NEXT_OPERATOR_START_INDEX = 3
    }
}
