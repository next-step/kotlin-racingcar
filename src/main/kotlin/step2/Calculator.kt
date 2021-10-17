package step2

import step2.ExceptionType.Companion.INPUT_MUST_END_WITH_NUMBER
import step2.ExceptionType.Companion.INPUT_MUST_NOT_BLANK
import step2.ExceptionType.Companion.INPUT_MUST_NOT_NULL
import step2.ExceptionType.Companion.INPUT_MUST_START_WITH_NUMBER
import step2.ExceptionType.Companion.NUMBER_NEXT_IS_MUST_OPERATOR
import step2.ExceptionType.Companion.OPERATOR_NEXT_IS_MUST_NUMBER

object Calculator {
    private fun String.isNumeric() = matches("-?\\d+(\\.\\d+)?".toRegex())
    private fun String.isNotNumeric() = !isNumeric()
    private fun String.getOperator() = OperatorType.getOperator(this)

    fun calculate(input: String?): Double {
        val checkedInput = checkInputValidation(input)
        val dividedList = checkedInput.split(" ")
        checkElementValidation(dividedList)

        var idx = 0
        var accumulator = dividedList.first().toDouble()

        while (idx < dividedList.size) {
            val divided = dividedList[idx++]
            require(divided.isNotNumeric()) { NUMBER_NEXT_IS_MUST_OPERATOR }
            val newValue = dividedList[idx++]
            require(newValue.isNumeric()) { OPERATOR_NEXT_IS_MUST_NUMBER }
            accumulator = divided.getOperator().execute(accumulator, newValue.toDouble())
        }
        return accumulator
    }

    private fun checkElementValidation(list: List<String>) {
        require(list.first().isNumeric()) { INPUT_MUST_START_WITH_NUMBER }
        require(list.last().isNumeric()) { INPUT_MUST_END_WITH_NUMBER }
    }

    private fun checkInputValidation(input: String?) = run {
        requireNotNull(input) { INPUT_MUST_NOT_NULL }
        require(input.isNotBlank()) { INPUT_MUST_NOT_BLANK }
        input
    }
}
