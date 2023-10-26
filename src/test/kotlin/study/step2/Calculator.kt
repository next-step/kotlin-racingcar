package study.step2

class Calculator() {

    fun calculate(input: String): Int {
        input.takeIf { it.isNotBlank() } ?: throw IllegalArgumentException("입력값이 비어있습니다.")

        val elements = input.split(" ")
        var result = elements[0].toIntOrNull() ?: throw IllegalArgumentException("올바르지 않는 입력값입니다.")

        for (i in 1 until elements.size step 2) {
            val operation = elements[i]
            val operand = elements[i + 1].toIntOrNull() ?: throw IllegalArgumentException("올바르지 않는 입력값입니다.")

            result = calculate(operation, result, operand)
        }
        return result
    }

    private fun calculate(operator: String, result: Int, operand: Int) = when (operator) {
        "+" -> add(result, operand)
        "-" -> subtract(result, operand)
        "*" -> multiply(result, operand)
        "/" -> divide(result, operand)
        else -> throw IllegalArgumentException("연산자는 +, -, *, / 중 하나여야 합니다.")
    }

    private fun add(a: Int, b: Int) = a + b
    private fun subtract(a: Int, b: Int) = a - b
    private fun multiply(a: Int, b: Int) = a * b
    private fun divide(a: Int, b: Int): Int {
        b.takeIf { it != 0 } ?: throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        return a / b
    }
}
