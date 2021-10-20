package step2.module

import step2.exception.BizException
import step2.exception.message.calculator.CalculatorMessage
import step2.exception.message.operator.OperatorMessage
import java.util.LinkedList
import java.util.Queue

class CalculatorParser : ParserModule {

    private val queue: Queue<String> = LinkedList()

    private fun String.isNullOrEmpty() {
        if (this.isEmpty()) throw BizException.CustomException(CalculatorMessage.NULL_AND_EMPTY)
    }

    private fun String.isDigit(): Boolean =
        try {
            this.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }

    private fun String.operatorCheck(): Boolean {
        return when (this) {
            "+" -> true
            "-" -> true
            "*" -> true
            "/" -> true
            else -> throw BizException.CustomException(OperatorMessage.NOT_OPERATOR)
        }
    }

    override fun parse(input: String): Queue<String> {

        input.isNullOrEmpty()

        val calculatorText = input.split(" ")

        for (text in calculatorText) {

            if (text.isDigit()) {
                queue.add(text)
                continue
            }

            if (text.operatorCheck()) {
                queue.add(text)
            }
        }
        return queue
    }
}
