package carRacing.View

import java.lang.IllegalStateException

class InputView(private val maxTryCount: Int = 3) {

    fun readLineNumber(question: String?, count: Int = 0): Int {
        try {
            val input: String = readLine(question, count)

            if (input.toIntOrNull() == null) {
                throw IllegalArgumentException("숫자를 입력해주세요.")
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
                val leftCount: Int = maxTryCount - count
                println("잘못된 입력입니다. ${leftCount}번 더 입력할 수 있습니다.")
            }

            println(question)
        }

        try {
            return readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다.")
        } catch (wrongInputException: IllegalArgumentException) {
            println(wrongInputException.message)

            if (count < this.maxTryCount) {
                return this.readLine(question, count + 1)
            } else {
                throw IllegalStateException("입력 횟수를 초과하였습니다.")
            }
        } catch (overTryException: IllegalStateException) {
            println(overTryException.message)
            throw IllegalStateException("입력 횟수를 초과하였습니다.")
        }
    }
}
