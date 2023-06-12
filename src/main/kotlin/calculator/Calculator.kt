package calculator

class Calculator(private val firstElement: Int, private val operator: String, private val secondElement: Int) {
    fun calculate() = when (operator) {
        "+" -> firstElement + secondElement
        "-" -> firstElement - secondElement
        "*" -> firstElement * secondElement
        "/" -> {
            if (secondElement == 0) throw IllegalArgumentException(" 나눗셈 분모 0 발생 ")
            firstElement / secondElement
        }
        else -> throw IllegalArgumentException(" 사칙연산기호 확인 ( $operator ) ")
    }
}
