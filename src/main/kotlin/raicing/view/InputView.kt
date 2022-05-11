package raicing.view

import raicing.Const

object InputView {
    fun readStrAndConvertToInt(infoMsg: String): Int {
        println(infoMsg)
        return requireNaturalNum(readlnOrNull())
    }

    private fun requireNaturalNum(inputStr: String?): Int {
        val inputInt = requireNotNull(inputStr?.toIntOrNull()) { Const.ErrorMsg.INPUT_IS_NOT_NATURAL_NUMBER_ERROR_MSG }
        require(inputInt > 0) { Const.ErrorMsg.INPUT_IS_NOT_NATURAL_NUMBER_ERROR_MSG }
        return inputInt
    }
}
