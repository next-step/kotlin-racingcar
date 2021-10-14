package stringArithmeticCalculator

class Calculator(private val input : String) {
    init {
        if(input.isBlank()) throw IllegalArgumentException("공백 문자는 올 수 없습니다.")
    }

    var result = 0

    fun result() : Int{
        calculate()
        return result
    }

    private fun calculate() {
        val list = input.split(" ")
        result = list[0].toInt()
        for(i in 1 until list.size) {
            operation(list, i)
        }
    }

    private fun operation(list: List<String>, i: Int) {
        if (list[i] == "+") {
            result += list[i+1].toInt()
        }
    }
}