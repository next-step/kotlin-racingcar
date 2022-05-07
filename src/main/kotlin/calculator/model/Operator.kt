package calculator.model

enum class Operator(
    val symbol: Char,
    val operator: (Int, Int) -> Int
) {

    PLUS('+', { num1, num2 -> num1 + num2 }),
    MINUS('-', { num1, num2 -> num1 - num2 }),
    MULTIPLICATION('*', { num1, num2 -> num1 * num2 }),
    DIVISION('/', { num1, num2 ->
        require(num2 != 0) { "나누는 수가 0이 될 수 없습니다." }
        num1 / num2
    });

    companion object {
        fun calculate(num1: Int, num2: Int, symbol: Char): Int {
            val operator = findOperator(symbol)
            return operator.operator(num1, num2)
        }

        private fun findOperator(symbol: Char): Operator {
            return Operator.values()
                .find { it.symbol == symbol }
                ?: throw IllegalArgumentException("존재하지 않는 수식 기호입니다. (symbol: $symbol)")
        }
    }
}
