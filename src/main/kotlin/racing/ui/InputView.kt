package racing.ui

import racing.data.RacingGameData
import racing.exception.ExceptionMessageConstants
import java.lang.IllegalArgumentException

object InputView {

    private const val QUESTION_CAR_NUM = "자동차 대수는 몇 대인가요?"
    private const val QUESTION_TRY_NUM = "시도할 횟수는 몇 회인가요?"

    fun askQuestion(): RacingGameData {

        val carCount = askCarNum()
        val tryCount = askTryNum()

        printNewLine()

        return RacingGameData(carCount, tryCount)
    }

    private fun askCarNum(): Int {
        println(QUESTION_CAR_NUM)
        return readNumber()
    }

    private fun askTryNum(): Int {
        println(QUESTION_TRY_NUM)
        return readNumber()
    }

    private fun readNumber(): Int {
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(ExceptionMessageConstants.INPUT_IS_NOT_NUMBER)
    }

    private fun printNewLine() {
        println()
    }
}
