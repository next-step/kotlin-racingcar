package racingcar

class InputView {
    fun getNaturalNumberInput(msg: String): Int {
        while (true) {
            val trialCountInput = getInputWithMessage(msg)
            val isValidInput = InputValidator.isNaturalNumber(trialCountInput)

            if (isValidInput) {
                return trialCountInput.toInt()
            }

            println("1이상 정수로 입력해주세요")
        }
    }

    private fun getInputWithMessage(msg: String): String {
        println(msg)
        return readln()
    }
}
