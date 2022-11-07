package racingcar.interfaces.ui.input.console

import racingcar.application.model.RacingCarInputCommand

object RacingCarInputConsole {

    private const val CAR_COUNT_QUESTION = "자동차 대수는 몇 대인가요?"
    private const val ATTEMPT_COUNT_QUESTION = "시도할 횟수는 몇 회인가요?"

    private const val INPUT_CORRECT_NUMBER_COMMENT = "올바른 숫자를 입력해주세요"

    fun input(): RacingCarInputCommand {
        val carCount = queryNumber(CAR_COUNT_QUESTION)
        val attemptCount = queryNumber(ATTEMPT_COUNT_QUESTION)
        return RacingCarInputCommand(carCount, attemptCount)
    }

    private fun queryNumber(question: String): Int =
        try {
            println(question)
            val numberString = readln()
            validateNumber(numberString)
            numberString.toInt()
        } catch (e: Exception) {
            queryNumber(question)
        }

    private fun validateNumber(string: String?) {
        try {
            require(!string.isNullOrEmpty()) { INPUT_CORRECT_NUMBER_COMMENT }
            string.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INPUT_CORRECT_NUMBER_COMMENT)
        }
    }
}
