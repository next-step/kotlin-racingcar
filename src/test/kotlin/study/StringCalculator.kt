package study

class StringCalculator {
    private val operator = listOf("+", "-", "*", "/")

    fun calculate(string: String): Int {
        val stringList = string.split(" ")
        val operatorList = stringList.filter { it in operator }
        val numberList = stringList.filter { it !in operator }.map { it.toInt() }
        val newNumberList = numberList.drop(1)
        val pairList = convertToPairList(operatorList,newNumberList)

       return calculateEveryPair(pairList,numberList[0])
    }

    private fun convertToPairList(operatorList: List<String>, newNumberList: List<Int>) : List<Pair<String,Int>>{
        val myMap = mutableMapOf<String,Int>()
        for (i in operatorList.indices) {
            myMap[operatorList[i]] = newNumberList[i]
        }
        return myMap.toList()
    }

    private fun calculateEveryPair(pairList: List<Pair<String,Int>>, initValue: Int) : Int{
        return pairList.fold(initValue) { acc, pair -> calculateOnePair(acc, pair) }
    }

    private fun calculateOnePair(number: Int, pair: Pair<String, Int>): Int {
        var result = number
        when (pair.first) {
            "+" -> result += pair.second
            "-" -> result -= pair.second
            "*" -> result *= pair.second
            "/" -> result /= pair.second
        }
        return result
    }
}


