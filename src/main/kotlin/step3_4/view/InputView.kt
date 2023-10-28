package step3_4.view

import step3_4.validator.CarNameValidator
import step3_4.validator.RoundNumberValidator

object InputView {

    fun enteredCarInformation(): List<String> {
        val input = readlnOrNull().orEmpty()
        val removeWhiteSpaceInput = input.replace(" ", "")
        val carNameList = removeWhiteSpaceInput.split(DELIMITERS)
        CarNameValidator.checkValidate(carNameList)
        return carNameList
    }

    fun enteredNumberOfRounds(): Int {
        val input = readlnOrNull().orEmpty()
        RoundNumberValidator.checkValidate(input)
        return input.toInt()
    }

    private const val DELIMITERS = ','
}
