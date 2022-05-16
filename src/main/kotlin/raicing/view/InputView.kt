package raicing.view

import raicing.Const
import raicing.model.NaturalNumber

object InputView {
    fun readStrAndConvertToNotNullStr(infoMsg: String): String {
        println(infoMsg)
        val inputStr = readlnOrNull()
        require(!inputStr.isNullOrBlank()) { Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG }
        return inputStr
    }

    fun readStrAndConvertToNaturalNum(infoMsg: String): NaturalNumber {
        println(infoMsg)
        return requireNaturalNum(readlnOrNull())
    }

    private fun requireNaturalNum(inputStr: String?): NaturalNumber {
        require(!inputStr.isNullOrBlank()) { Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG }
        return NaturalNumber(inputStr)
    }
}
