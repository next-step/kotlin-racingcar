package calculator

object Calculator {
    private const val FIRST_OPERAND_INDEX = 0
    private const val FIRST_OPERATOR_INDEX = 0
    private const val OPERATION_UNIT = 0

    fun calculate(expression: String): Int {
        require(expression.isNotBlank()) { "입력값이 공백입니다." }

        val parts = expression.split(" ")

        var result = parts[FIRST_OPERAND_INDEX].toInt()
        for (i in FIRST_OPERATOR_INDEX until parts.size step OPERATION_UNIT) {
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
            "/" -> {
                require(operand2 != 0) { "0으로 나눌 수 없습니다." }
                operand1 / operand2
            }
            else -> throw IllegalArgumentException("사칙연산 기호가 올바르지 않습니다. : $operator")
        }
    }
}
