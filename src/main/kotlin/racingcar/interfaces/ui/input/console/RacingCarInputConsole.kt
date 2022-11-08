package racingcar.interfaces.ui.input.console

import racingcar.application.model.RacingCarInputCommand

object RacingCarInputConsole {

    fun input(): RacingCarInputCommand {
        val carCount = queryNumber("자동차 대수는 몇 대인가요?")
        val attemptCount = queryNumber("시도할 횟수는 몇 회인가요?")
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
            require(!string.isNullOrEmpty()) { "올바른 숫자를 입력해주세요" }
            string.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력해주세요")
        }
    }
}
