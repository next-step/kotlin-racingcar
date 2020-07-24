package study

class StrCalculator(str: String) {
    val numList = str.split("+", "-", "*", "/").map(String::toInt)
    val symbolList = str.split("0", "1", "2", "3", "4", "5", "6", "7", "8", "9").filter { it != "" }

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

    fun isPlus(times: Int): Boolean {
        return symbolList[times] == "+"
    }

    fun isMinus(times: Int): Boolean {
        return symbolList[times] == "-"
    }

    fun isMultiplication(times: Int): Boolean {
        return symbolList[times] == "*"
    }

    fun isDivision(times: Int): Boolean {
        return symbolList[times] == "/"
    }
}
