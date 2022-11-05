package step2

import step2.converter.StringToInt
import step2.converter.ToInt
import step2.operator.Operator

class StringCalculator(
    private val spaceCharacter: String = " ",
) : ToInt<String> by StringToInt() {

    fun calculate(expression: String?): Int {
        requireNotNull(expression) { "${ErrorMessage.NULL_OR_BLANK}" }
        require(expression.isNotBlank()) { "${ErrorMessage.NULL_OR_BLANK}" }

        val expressionList = expression.split(spaceCharacter).filter { it.isNotBlank() }

        return calculate(expressionList)
    }

    private fun calculate(expressionList: List<String>): Int {
        val numberList = expressionList.slice(expressionList.indices step 2).map { toInt(it) }
        val operatorList = expressionList.slice(1 until expressionList.size step 2).map { Operator.of(it) }

        require(numberList.size == operatorList.size + 1) { "${ErrorMessage.NOT_ENOUGH_OPERAND}" }

        val numberIterator = numberList.iterator()
        var accumulator = numberIterator.next()

        for (operator in operatorList) {
            accumulator = operator.operate(accumulator, numberIterator.next())
        }

        return accumulator
    }
}
