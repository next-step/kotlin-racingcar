import java.lang.IllegalArgumentException

class StringCalculator {
    fun calculation(question: String):String{
        if(question.isBlank()) return ""
        val stringList = question.trim().split(" ")
        if(!isValid(stringList)) throw IllegalArgumentException("Invalid input. It must use like 1 + 2 * 3 / 4") // TODO
        return listCalculation(stringList)
    }

    private fun listCalculation(stringList: List<String>): String {
        // ["1","+","2","*","3] -> ["3","*","3] -> ["9"] -> "9"
        val newList = stringList.toMutableList()
        if(newList.size == 1) return newList[0]
        val cutList = newList.subList(3, newList.size)
        return when(newList[1]){
            "+" -> listCalculation(listOf(addition(newList[0], newList[2])) + cutList)
            "-" -> listCalculation(listOf(subtraction(newList[0], newList[2])) + cutList)
            "*" -> listCalculation(listOf(multiplication(newList[0], newList[2])) + cutList)
            "/" -> listCalculation(listOf(division(newList[0], newList[2])) + cutList)
            else -> throw IllegalArgumentException("Invalid symbol.")
        }
    }

    private fun addition(s1: String, s2: String) = "${s1.toDouble() + s2.toDouble()}"
    private fun subtraction(s1: String, s2: String) = "${s1.toDouble() - s2.toDouble()}"
    private fun multiplication(s1: String, s2: String) = "${s1.toDouble() * s2.toDouble()}"
    private fun division(s1: String, s2: String) = "${s1.toDouble() / s2.toDouble()}"

    private fun isValid(stringList: List<String>): Boolean {
        if(stringList.size % 2 == 0) return false
        stringList[0].toDoubleOrNull()?:return false
        stringList.last().toDoubleOrNull()?:return false
        stringList.indexOf("/").let{
            if(it != -1) return stringList[it+1] != "0"
        }
        return true
    }
}