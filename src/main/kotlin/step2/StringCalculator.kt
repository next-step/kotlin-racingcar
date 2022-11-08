package step2

import step2.converter.StringToInt
import step2.converter.ToInt
import step2.operator.Operator

class StringCalculator(
    private val spaceCharacter: String = " ",
) : ToInt<String> by StringToInt() {

    companion object {
        const val ERROR_MESSAGE_NULL_OR_BLANK = "Input value is Null or Blank"
        const val ERROR_MESSAGE_NOT_ENOUGH_OPERAND = "Not Enough Operand"
    }

    fun calculate(expression: String?): Int {
        requireNotNull(expression) { ERROR_MESSAGE_NULL_OR_BLANK }
        require(expression.isNotBlank()) { ERROR_MESSAGE_NULL_OR_BLANK }

        val expressionList = expression.split(spaceCharacter).filter { it.isNotBlank() }

        return calculate(expressionList)
    }

    private fun calculate(expressionList: List<String>): Int {
        val numberList = expressionList.slice(expressionList.indices step 2).map { toInt(it) }
        val operatorList = expressionList.slice(1 until expressionList.size step 2).map { Operator.of(it) }

        require(numberList.size == operatorList.size + 1) { ERROR_MESSAGE_NOT_ENOUGH_OPERAND }

        val numberIterator = numberList.iterator()
        var accumulator = numberIterator.next()

        for (operator in operatorList) {
            accumulator = operator.operate(accumulator, numberIterator.next())
        }

        return accumulator
    }
}
