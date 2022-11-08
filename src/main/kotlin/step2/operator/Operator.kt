package step2.operator

enum class Operator(
    private val operationString: String,
    private val operationFunction: (Int, Int) -> Int
) {
    PLUS("+", Int::plus),
    MINUS("-", Int::minus),
    TIMES("*", Int::times),
    DIV("/", Int::div),
    REM("%", Int::rem);

    companion object {

        const val ERROR_MESSAGE_INVALID_OPERATOR = "Not Supported Operator"

        fun of(operator: String): Operator =
            values().firstOrNull { it.operationString == operator }
                ?: throw IllegalArgumentException("$ERROR_MESSAGE_INVALID_OPERATOR [$operator]")
    }

    fun operate(left: Int, right: Int): Int = operationFunction(left, right)
}
