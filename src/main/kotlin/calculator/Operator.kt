package calculator

enum class Operator(val symbol: String, private val operation: IntOperation) {
    PLUS("+", { number1, number2 -> number1 + number2 }),
    MINUS("-", { number1, number2 -> number1 - number2 }),
    MULTIPLY("*", { number1, number2 -> number1 * number2 }),
    DIVIDE("/", { number1, number2 ->
        if (number2 == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다")
        number1 / number2
    });

    fun operate(number1: Int, number2: Int): Int {
        return operation.operate(number1, number2)
    }

    companion object {
        fun findOperator(symbol: String): Operator {
            return Operator.values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("사칙 연산 기호가 아닙니다")
        }
    }
}
