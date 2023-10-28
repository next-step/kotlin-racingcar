package step3_4.view

import step3_4.validator.RoundNumberValidator

object InputView {

    fun enterNumberOfCars(): Int {
        val input = readlnOrNull().orEmpty()
        return RoundNumberValidator.checkValidate(input)
    }

    fun enterNumberOfRounds(): Int {
        val input = readlnOrNull().orEmpty()
        return RoundNumberValidator.checkValidate(input)
    }
}
