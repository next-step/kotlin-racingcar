package step2

import step2.ExceptionType.Companion.INPUT_MUST_END_WITH_NUMBER
import step2.ExceptionType.Companion.INPUT_MUST_NOT_BLANK
import step2.ExceptionType.Companion.INPUT_MUST_NOT_NULL
import step2.ExceptionType.Companion.INPUT_MUST_START_WITH_NUMBER
import step2.NumericChecker.checkIsNumeric

object Calculator {

    fun calculate(input: String?): Double {
        val checkedInput = checkInputValidation(input)
        val dividedList = checkedInput.split(" ")
        checkElementValidation(dividedList)
        var idx = 0
        val accumulator = Operand(dividedList[idx++])
        while (idx < dividedList.size) {
            val operator = Operator(dividedList[idx++])
            val newValue = Operand(dividedList[idx++])
            operator.execute(accumulator, newValue)
        }
        return accumulator.value
    }

    private fun checkElementValidation(list: List<String>) = run {
        require(checkIsNumeric(list.first())) { INPUT_MUST_START_WITH_NUMBER }
        require(checkIsNumeric(list.last())) { INPUT_MUST_END_WITH_NUMBER }
        list
    }

    private fun checkInputValidation(input: String?) = run {
        requireNotNull(input) { INPUT_MUST_NOT_NULL }
        require(input.isNotBlank()) { INPUT_MUST_NOT_BLANK }
        input
    }
}
