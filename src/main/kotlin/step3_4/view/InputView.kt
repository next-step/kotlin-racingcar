package step3_4.view

import step3_4.validator.InputStringValidator

object InputView {

    fun enterNumberOfCars(): Int {
        val input = readlnOrNull().orEmpty()
        return InputStringValidator.checkValidate(input)
    }

    fun enterNumberOfRounds(): Int {
        val input = readlnOrNull().orEmpty()
        return InputStringValidator.checkValidate(input)
    }
}
