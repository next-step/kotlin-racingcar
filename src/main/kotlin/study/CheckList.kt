package study

import java.lang.IllegalArgumentException

object CheckList {
    fun checkNumList(numList: List<String>): MutableList<Int> {
        try {
            val checkList = numList.map(String::toInt).toMutableList()
            return checkList
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자가 아닌 값이 있습니다")
        }
    }

    fun checkSymbolList(symbolList: List<String>): List<String> {
        for (symbol in symbolList) {
            if (symbol != "+" && symbol != "-" && symbol != "*" && symbol != "/") {
                throw IllegalArgumentException("사칙연산이 아닌 문자가 있습니다")
            }
        }
        return symbolList
    }

    fun checkCouple(numList: MutableList<Int>, symbolList: List<String>): Boolean {
        return numList.size - 1 == symbolList.size
    }
}
