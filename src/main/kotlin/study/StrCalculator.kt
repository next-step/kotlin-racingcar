package study

class StrCalculator(str: String) {
    val numList = str.split("+", "-", "*", "/", " ").filter { it != "" }.map(String::toInt).toMutableList()
    val symbolList = str.split("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ").filter { it != "" }

    fun play(): Int {
        for (symbol in symbolList) {
            val calculateNumList = numList.subList(0, 2)
            val value = calculate(symbol, calculateNumList)
            changeList(calculateNumList, value!!)
        }
        return numList[0]
    }

    fun plus(list: List<Int>): Int {
        return list.sum()
    }

    fun minus(list: List<Int>): Int {
        return list[0] - list[1]
    }

    fun multiplication(list: List<Int>): Int {
        return list[0] * list[1]
    }

    fun division(list: List<Int>): Int {
        return list[0] / list[1]
    }

    fun isPlus(symbol: String): Boolean {
        return symbol == "+"
    }

    fun isMinus(symbol: String): Boolean {
        return symbol == "-"
    }

    fun isMultiplication(symbol: String): Boolean {
        return symbol == "*"
    }

    fun isDivision(symbol: String): Boolean {
        return symbol == "/"
    }

    fun changeList(list: MutableList<Int>, value: Int) {
        list[0] = value
        list.removeAt(1)
    }

    fun calculate(symbol: String, calculateNumList: MutableList<Int>): Int? {
        return when {
            isPlus(symbol) -> {
                plus(calculateNumList)
            }
            isMinus(symbol) -> {
                minus(calculateNumList)
            }
            isMultiplication(symbol) -> {
                multiplication(calculateNumList)
            }
            isDivision(symbol) -> {
                division(calculateNumList)
            }
            else -> null
        }
    }
}
