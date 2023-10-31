package carRacing.View

import carRacing.Domain.MessageGenerator
import carRacing.Enum.ErrorCode
import java.lang.IllegalStateException

class InputView(private val maxTryCount: Int = 3) {

    private val messageGenerator: MessageGenerator = MessageGenerator()

    fun readLineNumber(question: String?, count: Int = 0): Int {
        try {
            val input: String = readLine(question, count)

            if (input.toIntOrNull() == null) {
                throw IllegalArgumentException(messageGenerator.getErrorMessage(ErrorCode.INPUT_IS_NOT_NUMBER))
            }

            return input.toInt()
        } catch (notNumberException: IllegalArgumentException) {
            println(notNumberException.message)
            return this.readLineNumber(question, count + 1)
        }
    }

    private fun readLine(question: String?, count: Int = 0): String {
        if (question != null) {
            if (count > 0) {
                val leftCount: String = (maxTryCount - count).toString()
                println("${messageGenerator.getErrorMessage(ErrorCode.OVER_INPUT_TRY_LEFT, leftCount)}")
            }

            println(question)
        }

        try {
            return readlnOrNull() ?: throw IllegalArgumentException(messageGenerator.getErrorMessage(ErrorCode.INPUT_EMPTY))
        } catch (wrongInputException: IllegalArgumentException) {
            println(wrongInputException.message)

            if (count < this.maxTryCount) {
                return this.readLine(question, count + 1)
            } else {
                throw IllegalStateException(messageGenerator.getErrorMessage(ErrorCode.OVER_INPUT_TRY))
            }
        } catch (overTryException: IllegalStateException) {
            throw IllegalStateException(overTryException.message)
        }
    }
}
