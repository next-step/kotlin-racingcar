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

    companion object {
        const val CAR_NAMES_INPUT_DESC = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val TRIAL_NUMBER_INPUT_DESC = "시도할 횟수는 몇 회인가요?"
    }
}
