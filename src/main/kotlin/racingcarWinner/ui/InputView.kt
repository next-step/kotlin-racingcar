package racingcarWinner.ui

import racingcarWinner.util.MessageCode

object InputView {
    private const val SEPARATOR = ","
    private const val INPUT_REGEX = """^[가-힣a-zA-Z0-9,\s]*$"""

    fun inputCarNames(): List<String> {
        println(MessageCode.CarNamesInput.message)

        val carNames = requireNotNull(readLine())

        return validateCarNames(carNames).split(SEPARATOR)
    }

    fun inputTryNumber(): Int {
        println(MessageCode.TryNumberQuestion.message)
        return requireNotNull(readLine()?.toInt())
    }

    private fun validateCarNames(carNames: String): String {
        require(carNames.matches(INPUT_REGEX.toRegex())) { MessageCode.CarNamesInputFormatException.message }
        return carNames
    }
}
