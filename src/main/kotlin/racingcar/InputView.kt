package racingcar

class InputView {
    fun getNaturalNumberInput(msg: String): Int {
        while (true) {
            val trialCountInput = getInputWithMessage(msg)
            try {
                InputValidator.checkNaturalNumber(trialCountInput)
                return trialCountInput.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getCarNamesInput(msg: String): List<String> {
        while (true) {
            val namesString = getInputWithMessage(msg)
            try {
                val splitted = namesString.split(",")
                InputValidator.checkNameLength(splitted)
                return splitted
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getInputWithMessage(msg: String): String {
        println(msg)
        return readln()
    }
}
