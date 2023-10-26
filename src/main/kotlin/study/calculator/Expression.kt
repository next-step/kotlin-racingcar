package study.calculator

class Expression(private val operatorToken: String, private val numberToken: String) {
    val operator: Operator = when (operatorToken) {
        "+" -> Operator.ADD
        "-" -> Operator.SUBTRACT
        "*" -> Operator.MULTIPLY
        "/" -> Operator.DIVIDE
        else -> throw IllegalArgumentException("invalid operator")
    }

    val number: Int = numberToken.toIntOrNull()
        ?: throw IllegalArgumentException("invalid number")

    enum class Operator(
        val evaluate: (Int, Int) -> Int
    ) {
        ADD({ number1, number2 -> number1 + number2 }),
        SUBTRACT({ number1, number2 -> number1 - number2 }),
        MULTIPLY({ number1, number2 -> number1 * number2 }),
        DIVIDE({ number1, number2 -> number1 / number2 });
    }
}
