package calculator

import calculator.util.isNumeric
import calculator.util.isOddSize

data class Expression(
    private val rawExpression: List<String>
) {
    init {
        require(isMoreThanMinimumSize()) { "계산할 수 있는 최소 입력 값을 입력해주세요." }
        require(isCorrectSize()) { "홀수개의 연산자와 짝수개의 피연산자가 존재 해야 합니다." }
        require(isCorrectExpression()) { "수식이 올바르지 않습니다." }
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

    private fun isMoreThanMinimumSize() = rawExpression.size > MIN_SIZE

    private fun isCorrectSize() = rawExpression.isOddSize()

    private fun isCorrectExpression() = rawExpression.withIndex()
        .all { (idx, data) ->
            when (idx % 2 == 0) {
                true -> data.isNumeric()
                false -> Operator.exist(data)
            }
        }

    companion object {
        private const val FIRST_INDEX = 1
        private const val CHUNK_SIZE = 2
        private const val MIN_SIZE = 2
    }
}
