package study

class StrCalculator(str: String) {
    private val checkNumList = str.split("+", "-", "*", "/", " ").filter { it != "" }
    private val checkSymbolList = str.split("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ").filter { it != "" }
    private val direction = Direction
    private val checkList = CheckList
    val numList = checkList.checkNumList(checkNumList)
    val symbolList = checkList.checkSymbolList(checkSymbolList)

    fun runCalculator(): Int {
        checkCouple()
        for (symbol in symbolList) {
            val calculateNumList = numList.subList(0, 2)
            val value = direction.calculate(symbol, calculateNumList)
            changeList(calculateNumList, value)
        }
        return numList[0]
    }

    private fun changeList(list: MutableList<Int>, value: Int) {
        list[0] = value
        list.removeAt(1)
    }

    private fun checkCouple() {
        if (!checkList.checkCouple(numList, symbolList)) {
            throw Exception("숫자와 기호의 쌍이 맞지 않습니다")
        }
    }
}
