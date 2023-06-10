package calculator

class Calculator {
    fun calculate(expression: String): Int {
        if (expression.isBlank()) {
            throw IllegalArgumentException("입력값이 공백입니다.")
        }

        val parts = expression.split(" ")

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
            else -> throw IllegalArgumentException("사칙연산 기호가 올바르지 않습니다. : $operator")
        }
    }
}
