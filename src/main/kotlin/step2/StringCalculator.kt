package step2

import java.lang.NumberFormatException

class StringCalculator(
    private val plus: String = "+",
    private val minus: String = "-",
    private val times: String = "*",
    private val div: String = "/",
    private val rem: String = "%",
    private val spaceCharacter: String = " ",
    private val toNumber: (String) -> Int = String::toInt
) {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("${ErrorMessage.NULL_OR_BLANK}")
        }

        val expressionList = expression.split(spaceCharacter).filter { it.isNotBlank() }

        return calculate(expressionList)
    }

    private fun calculate(expressionList: List<String>): Int {
        var accumulator = toValue(expressionList[0])
        for (i in 1 until expressionList.size step 2) {
            if (i + 1 >= expressionList.size) {
                throw IllegalArgumentException("${ErrorMessage.NOT_ENOUGH_OPERAND}")
            }

            accumulator = operator(expressionList[i])(accumulator, toValue(expressionList[i + 1]))
        }

        return accumulator
    }

    private fun operator(operator: String): (Int, Int) -> Int =
        when (operator) {
            plus -> Int::plus
            minus -> Int::minus
            times -> Int::times
            div -> Int::div
            rem -> Int::rem
            else -> throw IllegalArgumentException("${ErrorMessage.INVALID_OPERATOR} [$operator]")
        }

    private fun toValue(expression: String): Int = try { toNumber(expression) } catch (e: NumberFormatException) {
        throw IllegalArgumentException("${ErrorMessage.INVALID_NUMBER_FORMAT} [$expression]")
    }
}
