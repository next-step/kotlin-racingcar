package calculator

enum class Operator(val symbol: String, private val operation: IntOperation) {
    PLUS("+", IntOperation { number1, number2 -> number1 + number2 }),
    MINUS("-", IntOperation { number1, number2 -> number1 - number2 }),
    MULTIPLY("*", IntOperation { number1, number2 -> number1 * number2 }),
    DIVIDE("/", IntOperation { number1, number2 -> number1 / number2 });

    fun operate(number1: Int, number2: Int): Int {
        validate(number2)
        return operation.operate(number1, number2)
    }

    private fun validate(number2: Int) {
        if (this == DIVIDE && number2 == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다")
        }
    }

    companion object {
        fun findOperator(symbol: String): Operator {
            return Operator.values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("사칙 연산 기호가 아닙니다")
        }
    }
}
