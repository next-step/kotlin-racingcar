package calculator

class Calculator {
    fun calculate(input: String): Int {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값이 공백입니다.")
        }

        val parts = input.split(" ")

        var result = parts[0].toInt()
        for (i in 1 until parts.size step 2) {
            val operator = parts[i]
            val nextNumber = parts[i + 1].toInt()
            result = operate(result, operator, nextNumber)
        }

        return result
    }

    private fun operate(operand1: Int, operator: String, operand2: Int): Int {
        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> throw IllegalArgumentException("사칙연산 기호가 올바르지 않습니다.")
        }
    }
}
