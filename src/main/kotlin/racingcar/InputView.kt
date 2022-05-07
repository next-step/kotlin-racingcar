package racingcar

class InputView {
    fun getNaturalNumberInput(msg: String): Int {
        while (true) {
            val trialCountInput = getInputWithMessage(msg)
            try {
                InputValidator.checkNaturalNumber(trialCountInput)
                return trialCountInput.toInt()
            } catch (e: IllegalArgumentException) {
                println("1이상 정수로 입력해주세요")
            }
        }
    }

    private fun getInputWithMessage(msg: String): String {
        println(msg)
        return readln()
    }
}
