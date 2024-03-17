package calculator

enum class Operator(
    private val operatorRegex: String,
    private val operator: (Number, Number) -> Number
) {
    ADDITION(
        operatorRegex = "+",
        operator = { a, b -> Number(a.number + b.number)}
    ),
    SUBTRACTION(
        operatorRegex = "-",
        operator = { a, b -> Number(a.number - b.number) }
    ),
    MULTIPLICATION(
        operatorRegex = "*",
        operator = { a, b -> Number(a.number * b.number) }
    ),
    DIVISION(
        operatorRegex = "/",
        operator = { a, b -> Number(a.number / b.number) }
    );

    fun calculate(a: Number, b: Number): Number {
        return operator(a, b)
    }

    companion object {
        fun fromString(operatorRegex: String): Operator {
            return values().firstOrNull() { it.operatorRegex == operatorRegex }
                ?: throw IllegalArgumentException("$operatorRegex is not supported operator.")
        }
    }
}