package racing.ui

import racing.data.RacingGameData

object InputView {

    private const val QUESTION_CAR_NUM = "자동차 대수는 몇 대인가요?"
    private const val QUESTION_TRY_NUM = "시도할 횟수는 몇 회인가요?"
    private const val EXCEPTION_MESSAGE_INPUT_IS_NOT_NUMBER = "숫자가 아닌 입력값이 들어왔습니다."

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
        val inputNum = readLine()?.toIntOrNull()
        return inputNum ?: throw IllegalArgumentException(EXCEPTION_MESSAGE_INPUT_IS_NOT_NUMBER)
    }

    private fun printNewLine() {
        println()
    }
}
