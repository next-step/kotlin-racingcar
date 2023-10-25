package study.step2

class Calculator() {

    fun add(a: Int, b: Int) = a + b
    fun subtract(a: Int, b: Int) = a - b
    fun multiply(a: Int, b: Int) = a * b
    fun divide(a: Int, b: Int): Int {
        if (b == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        return a / b
    }

    fun calculate(input: String): Int {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값이 비어있습니다.")
        }

        val element = input.split(" ")
        var result = element[0].toInt()

        for (i in 1 until element.size step 2) {
            val operator = element[i]
            val operand = element[i + 1].toInt()

            result = when (operator) {
                "+" -> result + operand
                "-" -> result - operand
                "*" -> result * operand
                "/" -> result / operand
                else -> throw IllegalArgumentException("연산자는 +, -, *, / 중 하나여야 합니다.")
            }
        }
        return result
    }
}
