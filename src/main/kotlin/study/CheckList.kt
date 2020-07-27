package study

import java.lang.IllegalArgumentException

object CheckList {
    fun checkNumList(numList: List<String>): MutableList<Int> {
        try {
            return numList.map(String::toInt).toMutableList()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자가 아닌 값이 있습니다")
        }
    }

    fun checkSymbolList(symbolList: List<String>): Boolean {
        for (symbol in symbolList) {
            if (symbol != "+" && symbol != "-" && symbol != "*" && symbol != "/") {
                throw IllegalArgumentException("사칙연산이 아닌 문자가 있습니다")
            }
        }
        return true
    }

    fun checkCouple(numList: MutableList<Int>, symbolList: List<String>): Boolean {
        return numList.size - 1 == symbolList.size
    }
}
