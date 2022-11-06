package calculator

import calculator.const.CalculatorException
import calculator.util.isNumeric
import calculator.util.isOddSize

data class Expression(
    private val rawExpression: List<String>
) {
    init {
        isEnoughSize()
        isCorrectSize()
        isCorrectExpression()
    }

    fun calculate(): Double {
        val calculateData = rawExpression
            .drop(FIRST_INDEX)
            .chunked(CHUNK_SIZE)
            .map { (operator, operand) ->
                Operator.from(operator) to operand.toDouble()
            }

        return calculateData.fold(rawExpression.first().toDouble()) { acc, (operator, operand) ->
            operator(acc, operand)
        }
    }

    private fun isEnoughSize() =
        require(rawExpression.size > MIN_SIZE) { CalculatorException.NOT_ENOUGH_SIZE }

    private fun isCorrectSize() =
        require(rawExpression.isOddSize()) { CalculatorException.NOT_PROPER_SIZE }

    private fun isCorrectExpression() =
        require(
            rawExpression.withIndex()
                .all { (idx, data) ->
                    when (idx % 2 == 0) {
                        true -> data.isNumeric()
                        false -> Operator.exist(data)
                    }
                }
        ) { CalculatorException.NOT_CORRECT_EXPRESSION }

    companion object {
        private const val FIRST_INDEX = 1
        private const val CHUNK_SIZE = 2
        private const val MIN_SIZE = 2
    }
}
