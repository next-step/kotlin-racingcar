package study

import java.lang.IllegalArgumentException

class CheckList() {
    fun checkNumList(numList: List<String>): MutableList<Int> {
        try {
            val checkList = numList.map(String::toInt).toMutableList()
            return checkList
        } catch (e: NumberFormatException) {
            println("숫자만 계산할수있습니다.")
            throw NumberFormatException("숫자가 아닌 값이 있습니다")
        }
    }

    fun checkSymbolList(symbolList: List<String>): List<String> {
        for (symbol in symbolList) {
            if (symbol != "+" && symbol != "-" && symbol != "*" && symbol != "/") {
                println("사칙연산만 가능합니다")
                throw IllegalArgumentException("사칙연산이 아닌 문자가 있습니다")
            }
        }
        return symbolList
    }

    fun checkCouple(numList: MutableList<Int>, symbolList: List<String>): Boolean {
        return numList.size - 1 == symbolList.size
    }
}
