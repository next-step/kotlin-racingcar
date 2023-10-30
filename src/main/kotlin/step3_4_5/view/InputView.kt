package step3_4_5.view

import step3_4_5.view.validator.RoundNumberValidator

object InputView {

    fun processEnteredCarInformation(): List<String> {
        val input = readln()
        return splitEnteredCarInformation(input)
    }

    private fun splitEnteredCarInformation(input: String): List<String> {
        val removeWhiteSpaceInput = input.replace(" ", "")
        return removeWhiteSpaceInput.split(DELIMITERS)
    }

    fun processEnteredNumberOfRounds(): Int {
        val input = readln()
        RoundNumberValidator.checkValidate(input)
        return input.toInt()
    }

    private const val DELIMITERS = ','
}
