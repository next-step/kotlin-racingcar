package step2

import step2.ExceptionType.Companion.INPUT_MUST_END_WITH_NUMBER
import step2.ExceptionType.Companion.INPUT_MUST_NOT_BLANK
import step2.ExceptionType.Companion.INPUT_MUST_NOT_NULL
import step2.ExceptionType.Companion.INPUT_MUST_START_WITH_NUMBER
import step2.NumericChecker.checkIsNumeric
import java.util.LinkedList
import java.util.Queue

object Calculator {

    fun calculate(input: String?): Double {
        val checkedInput = checkInputValidation(input)
        val calculateQueue = LinkedList(checkedInput.split(" ")) as Queue<String>
        checkElementValidation(calculateQueue)
        val accumulator = Operand(calculateQueue.poll())
        while (calculateQueue.isNotEmpty()) {
            val operator = Operator(calculateQueue.poll())
            val newValue = Operand(calculateQueue.poll())
            operator.execute(accumulator, newValue)
        }
        return accumulator.value
    }

    private fun checkElementValidation(queue: Queue<String>) = run {
        require(checkIsNumeric(queue.first())) { INPUT_MUST_START_WITH_NUMBER }
        require(checkIsNumeric(queue.last())) { INPUT_MUST_END_WITH_NUMBER }
        queue
    }

    private fun checkInputValidation(input: String?) = run {
        requireNotNull(input) { INPUT_MUST_NOT_NULL }
        require(input.isNotBlank()) { INPUT_MUST_NOT_BLANK }
        input
    }
}
