package racingcarWinner.ui

import racingcarWinner.core.MessageCode

object InputView {
    private const val SEPARATOR = ","

    fun inputCarNames(): List<String> {
        println(MessageCode.CarNamesInput.message)
        return requireNotNull(readLine()).split(SEPARATOR)
    }

    fun inputTryNumber(): Int {
        println(MessageCode.TryNumberQuestion.message)
        return requireNotNull(readLine()?.toInt())
    }
}
