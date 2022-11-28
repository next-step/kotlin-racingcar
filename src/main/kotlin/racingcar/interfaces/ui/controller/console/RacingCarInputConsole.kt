package racingcar.interfaces.ui.controller.console

import racingcar.application.model.RaceInputCommand

object RacingCarInputConsole {

    fun input(): RaceInputCommand {
        val carCount = queryNumber("자동차 대수는 몇 대인가요?")
        val carNames = queryStringList("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        check(carCount == carNames.size) { "자동차의 개수와 입력한 이름의 개수는 동일해야 합니다." }

        val attemptCount = queryNumber("시도할 횟수는 몇 회인가요?")
        return RaceInputCommand(carNames, attemptCount)
    }

    private fun queryStringList(question: String): List<String> {
        println(question)
        return readln().split(",")
    }

    private fun queryNumber(question: String): Int =
        try {
            println(question)
            val numberString = readln()
            validateNumber(numberString)
            numberString.toInt()
        } catch (e: IllegalArgumentException) {
            queryNumber(question)
        }

    private fun validateNumber(string: String) {
        try {
            require(string.isNotBlank()) { "올바른 숫자를 입력해주세요" }
            string.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력해주세요")
        }
    }
}
