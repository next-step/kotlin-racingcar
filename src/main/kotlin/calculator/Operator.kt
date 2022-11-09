package calculator

enum class Operator(
    val symbol: String,
    val calculate: (Double, Double) -> Double
) {
    PLUS(
        symbol = "+",
        calculate = { operand1, operand2 -> operand1 + operand2 }
    ),
    MINUS(
        symbol = "-",
        calculate = { operand1, operand2 -> operand1 - operand2 }
    ),
    MULTIPLY(
        symbol = "*",
        calculate = { operand1, operand2 -> operand1 * operand2 }
    ),
    DIVIDE(
        symbol = "/",
        calculate = { operand1, operand2 ->
            if (operand2 != 0.0) {
                operand1 / operand2
            } else {
                throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            }
        }
    );

    companion object {
        fun of(symbol: String) = values()
            .find { it.symbol == symbol }
            ?: throw IllegalArgumentException("잘못된 사칙연산 기호가 아닙니다.")
    }
}
