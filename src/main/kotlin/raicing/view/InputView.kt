package raicing.view

import raicing.Const
import raicing.model.NaturalNumber

object InputView {
    fun readStrAndConvertToInt(infoMsg: String): NaturalNumber {
        println(infoMsg)
        return requireNaturalNum(readlnOrNull())
    }

    private fun requireNaturalNum(inputStr: String?): NaturalNumber {
        require(!inputStr.isNullOrBlank()) { Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MST }
        return NaturalNumber.number(inputStr)
    }
}
