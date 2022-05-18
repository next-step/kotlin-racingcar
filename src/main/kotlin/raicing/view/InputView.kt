package raicing.view

import raicing.Const
import raicing.model.CarInfo
import raicing.model.NaturalNumber

object InputView {
    private const val INPUT_DELIMITER = ','

    fun readStrAndConvertToList(infoMsg: String): List<CarInfo> {
        println(infoMsg)
        val inputStr = readlnOrNull()
        require(!inputStr.isNullOrBlank()) { Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG }
        return splitCarNames(inputStr)
    }

    fun readStrAndConvertToNaturalNum(infoMsg: String): NaturalNumber {
        println(infoMsg)
        return requireNaturalNum(readlnOrNull())
    }

    private fun requireNaturalNum(inputStr: String?): NaturalNumber {
        require(!inputStr.isNullOrBlank()) { Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG }
        return NaturalNumber(inputStr)
    }

    private fun splitCarNames(carNameStr: String): List<CarInfo> {
        val carNames = carNameStr.split(INPUT_DELIMITER)
        return carNames.map { carName ->
            CarInfo(carName.trim())
        }
    }
}
