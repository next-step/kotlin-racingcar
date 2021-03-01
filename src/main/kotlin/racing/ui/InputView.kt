package racing.ui

import racing.data.RacingGameData

object InputView {

    private const val QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val CAR_NAME_DELIMETER = ","
    private const val QUESTION_TRY_NUM = "시도할 횟수는 몇 회인가요?"
    private const val EXCEPTION_MESSAGE_CAR_NAMES_IS_NULL = "자동차 이름 값이 없습니다."
    private const val EXCEPTION_MESSAGE_INPUT_IS_NOT_NUMBER = "숫자가 아닌 입력값이 들어왔습니다."

    fun askQuestion(): RacingGameData {

        val carNames = askCarName()
        val tryCount = askTryNum()

        printNewLine()

        return RacingGameData(carNames, tryCount)
    }

    private fun askCarName(): List<String> {
        println(QUESTION_CAR_NAME)
        return readCarNames()
    }

    private fun readCarNames(): List<String> {
        val inputCarNames = readLine() ?: throw IllegalArgumentException(EXCEPTION_MESSAGE_CAR_NAMES_IS_NULL)
        return inputCarNames.split(CAR_NAME_DELIMETER)
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
