package step2

import step2.ExceptionType.INPUT_MUST_END_WITH_NUMBER
import step2.ExceptionType.INPUT_MUST_NOT_BLANK
import step2.ExceptionType.INPUT_MUST_NOT_NULL
import step2.ExceptionType.INPUT_MUST_START_WITH_NUMBER
import step2.NumericChecker.checkIsNumeric
import java.util.LinkedList
import java.util.Queue

object Calculator {

    fun calculate(input: String?): Double {
        checkInputValidation(input)
        val calculateQueue = LinkedList(input!!.split(" ")) as Queue<String>
        checkElementValidation(calculateQueue)
        var accumulator = Operand(calculateQueue.poll())
        while (calculateQueue.isNotEmpty()) {
            val operator = Operator(calculateQueue.poll())
            val newValue = Operand(calculateQueue.poll())
            accumulator = operator.execute(accumulator, newValue)
        }
        return accumulator.value
    }

    private fun checkElementValidation(queue: Queue<String>): Boolean {
        require(checkIsNumeric(queue.firstOrNull())) { INPUT_MUST_START_WITH_NUMBER }
        require(checkIsNumeric(queue.lastOrNull())) { INPUT_MUST_END_WITH_NUMBER }
        return true
    }

    private fun checkInputValidation(input: String?): Boolean {
        requireNotNull(input) { INPUT_MUST_NOT_NULL }
        require(input.isNotBlank()) { INPUT_MUST_NOT_BLANK }
        return true
    }
}
