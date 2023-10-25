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

        val elements = input.split(" ")
        var result = elements[0].toIntOrNull() ?: throw IllegalArgumentException("올바르지 않는 입력값입니다.")

        for (i in 1 until elements.size step 2) {
            val operator = elements[i]
            val operand = elements[i + 1].toIntOrNull() ?: throw IllegalArgumentException("올바르지 않는 입력값입니다.")

            result = operand(operator, result, operand)
        }
        return result
    }

    private fun operand(operator: String, result: Int, operand: Int) = when (operator) {
        "+" -> result + operand
        "-" -> result - operand
        "*" -> result * operand
        "/" -> result / operand
        else -> throw IllegalArgumentException("연산자는 +, -, *, / 중 하나여야 합니다.")
    }
}
