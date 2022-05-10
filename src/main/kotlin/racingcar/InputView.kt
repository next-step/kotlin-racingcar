package racingcar

class InputView {
    fun getNaturalNumberInput(msg: String): Int {
        while (true) {
            val trialCountInput = getInputWithMessage(msg)
            try {
                InputValidator.checkNaturalNumber(trialCountInput)
                return trialCountInput.toInt()
            } catch (e: IllegalArgumentException) {
                println(ERROR_MSG_FOR_NATURAL_NUMBER)
            }
        }
    }

    fun getCarNamesInput(msg: String): List<String> {
        while (true) {
            val namesString = getInputWithMessage(msg)
            try {
                val splitted = namesString.split(",")
                require(splitted.any { it.length <= MAX_NAME_LENGTH })
                return splitted
            } catch (e: IllegalArgumentException) {
                println(ERROR_MSG_FOR_NAME_LENGTH)
            }
        }
    }

    private fun getInputWithMessage(msg: String): String {
        println(msg)
        return readln()
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val ERROR_MSG_FOR_NATURAL_NUMBER = "1이상 정수로 입력하세요"
        private const val ERROR_MSG_FOR_NAME_LENGTH = "자동차 이름은 ${MAX_NAME_LENGTH}자를 초과할 수 없어요"
    }
}
