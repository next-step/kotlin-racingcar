package racingcar

class InputView {
    fun getNaturalNumberInput(msg: String): Int {
        var trialCountInput: String
        do {
            trialCountInput = getInputWithMessage(msg)
        } while (isUserTypedNaturalNumber(trialCountInput).not())

        return trialCountInput.toInt()
    }

    private fun isUserTypedNaturalNumber(input: String): Boolean {
        return try {
            InputValidator.checkNaturalNumber(input)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }

    fun getCarNamesInput(msg: String): List<String> {
        var splitted: List<String>

        do {
            val namesString = getInputWithMessage(msg)
            splitted = namesString.split(",")
        } while (isUserTypedValidNames(splitted).not())

        return splitted
    }

    private fun isUserTypedValidNames(input: List<String>): Boolean {
        return try {
            InputValidator.checkNameLength(input)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }

    private fun getInputWithMessage(msg: String): String {
        println(msg)
        return readln()
    }
}
