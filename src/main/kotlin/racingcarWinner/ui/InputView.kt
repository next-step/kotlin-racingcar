package racingcarWinner.ui

import racingcarWinner.util.MessageCode

object InputView {
    const val INIT_TRY_NUMBER = 1
    private const val SEPARATOR = ","
    private const val INPUT_REGEX = """^[가-힣a-zA-Z0-9,\s]*$"""

    fun inputCarNames(): List<String> {
        println(MessageCode.CarNamesInput.message)

        val carNames = requireNotNull(readLine())

        return validateCarNames(carNames).split(SEPARATOR)
    }

    fun inputTryNumber(): Int {
        println(MessageCode.TryNumberQuestion.message)

        val tryNumber = requireNotNull(readLine()?.toInt())

        return validateTryNumber(tryNumber)
    }

    private fun validateCarNames(carNames: String): String {
        require(carNames.matches(INPUT_REGEX.toRegex())) { MessageCode.CarNamesInputFormatException.message }
        return carNames
    }

    private fun validateTryNumber(tryNumber: Int): Int {
        require(tryNumber >= INIT_TRY_NUMBER) { MessageCode.TryNumberException.message }
        return tryNumber
    }
}
