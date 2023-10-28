package step3.view

import step3.validator.InputStringValidator

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
