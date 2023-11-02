package calculator.domain

class Calculator {

    fun calculate(number1: Int, operator: Char, number2: Int): Int {
        return when (operator) {
            '+' -> {
                number1 + number2
            }
            '-' -> {
                number1 - number2
            }
            '*' -> {
                number1 * number2
            }
            '/' -> {
                require(number2 != 0) { "0으로 나눌 수 없습니다." }
                number1 / number2
            }
            else -> throw IllegalArgumentException("올바르지 않은 연산자 입니다.")
        }
    }
}
