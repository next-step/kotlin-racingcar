package carRacing.view

import carRacing.enum.ErrorCode
import kotlin.IllegalStateException

class InputView(private val maxTryCount: Int = 3) {

    private val messageGenerator: MessageGenerator = MessageGenerator()

    fun readLineNumber(question: String?, count: Int = 0): Int {
        val inputResult: Result<Int> = runCatching {
            val input: String = readLine(question, count)

            if (input.toIntOrNull() == null) {
                throw IllegalArgumentException(messageGenerator.getErrorMessage(ErrorCode.INPUT_IS_NOT_NUMBER))
            }

            return input.toInt()
        }.onFailure {
            println(it.message)

            if (it is IllegalArgumentException) {
                return this.readLineNumber(question, count + 1)
            }
        }

        return inputResult.getOrThrow()
    }

    fun readLineList(question: String?, count: Int = 0, separator: String = ","): List<String> {
        val inputResult: Result<List<String>> = runCatching {
            val input: String = readLine(question, count)

            return input.split(separator)
        }.onFailure {
            println(it.message)

            if (it is IllegalArgumentException) {
                return this.readLineList(question, count + 1, separator)
            }
        }

        return inputResult.getOrThrow()
    }

    private fun readLine(question: String?, count: Int = 0): String {
        val inputResult: Result<String> = runCatching {
            if (count >= this.maxTryCount) {
                throw IllegalStateException(messageGenerator.getErrorMessage(ErrorCode.OVER_INPUT_TRY))
            }

            if (question != null) {
                if (count > 0) {
                    val leftCount: String = (maxTryCount - count).toString()
                    println(messageGenerator.getErrorMessage(ErrorCode.OVER_INPUT_TRY_LEFT, leftCount))
                }

                println(question)
            }

            return readlnOrNull() ?: throw IllegalArgumentException(messageGenerator.getErrorMessage(ErrorCode.INPUT_EMPTY))
        }.onFailure {
            if (count < this.maxTryCount) {
                return this.readLine(question, count + 1)
            }

            throw IllegalStateException(messageGenerator.getErrorMessage(ErrorCode.OVER_INPUT_TRY))
        }

        return inputResult.getOrThrow()
    }
}
