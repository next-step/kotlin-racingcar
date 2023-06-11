package calculator

class Calculator(private val firstElement: Int, private val operator: Char, private val secondElement: Int) {

    fun calcuate() = when (operator) {
        '+' -> add()
        '-' -> subtract()
        '*' -> multiply()
        '/' -> divide()
        else -> throw IllegalArgumentException(" 사칙연산기호 확인 ")
    }

    private fun add() = firstElement + secondElement
    private fun subtract() = firstElement + secondElement
    private fun multiply() = firstElement * secondElement
    private fun divide() = firstElement / secondElement
}
