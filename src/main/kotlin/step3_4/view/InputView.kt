package step3_4.view

import step3_4.validator.CarNamesDuplicateValidator
import step3_4.validator.RoundNumberValidator

object InputView {

    fun processEnteredCarInformation(): List<String> {
        val input = readln()
        val carNameList = splitEnteredCarInformation(input)
        CarNamesDuplicateValidator.checkValidate(carNameList)
        return carNameList
    }

    private fun splitEnteredCarInformation(input: String): List<String> {
        val removeWhiteSpaceInput = input.replace(" ", "")
        return removeWhiteSpaceInput.split(DELIMITERS)
    }

    fun processEnteredNumberOfRounds(): Int {
        val input = readlnOrNull().orEmpty()
        RoundNumberValidator.checkValidate(input)
        return input.toInt()
    }

    private const val DELIMITERS = ','
}
