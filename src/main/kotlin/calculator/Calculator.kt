package calculator

object Calculator {
    private const val FIRST_OPERAND_INDEX = 0
    private const val FIRST_OPERATOR_INDEX = 1
    private const val OPERATION_UNIT = 2

    fun calculate(expression: String): Int {
        require(expression.isNotBlank()) { "입력값이 공백입니다." }

        val parts = expression.split(" ")

        var result = parts[FIRST_OPERAND_INDEX].toInt()
        for (i in FIRST_OPERATOR_INDEX until parts.size step OPERATION_UNIT) {
            val operator = Operator.of(parts[i])
            val nextNumber = parts[i + 1].toInt()
            result = operator.operate(result, nextNumber)
        }

        return result
    }
}
