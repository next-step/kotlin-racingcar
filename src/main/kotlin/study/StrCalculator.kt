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

    fun minus(a: Int, b: Int): Int {
        return a - b
    }

    fun multiplication(a: Int, b: Int): Int {
        return a * b
    }

    fun division(a: Int, b: Int): Int {
        return a / b
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
                minus(calculateNumList[0], calculateNumList[1])
            }
            isMultiplication(symbol) -> {
                multiplication(calculateNumList[0], calculateNumList[1])
            }
            isDivision(symbol) -> {
                division(calculateNumList[0], calculateNumList[1])
            }
            else -> null
        }
    }
}
