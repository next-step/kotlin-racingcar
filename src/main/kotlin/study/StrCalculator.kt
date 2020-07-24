package study

class StrCalculator(str: String) {
    val numList = str.split("+", "-", "*", "/").map(String::toInt)
    val fpoList = str.split("0", "1", "2", "3", "4", "5", "6", "7", "8", "9").filter { it != "" }

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
}
