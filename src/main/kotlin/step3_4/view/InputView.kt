package step3_4.view

import step3_4.validator.CarNameValidator
import step3_4.validator.RoundNumberValidator

object InputView {

    fun enterNumberOfCars(): Int {
        val input = readlnOrNull().orEmpty()
        val carNameList = input.split(DELIMITERS)
        CarNameValidator.checkValidate(carNameList)
        return carNameList.count()
    }

    fun enterNumberOfRounds(): Int {
        val input = readlnOrNull().orEmpty()
        RoundNumberValidator.checkValidate(input)
        return input.toInt()
    }

    private const val DELIMITERS = ','
}
