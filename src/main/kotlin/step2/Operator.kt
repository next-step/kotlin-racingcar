package step2

enum class Operator(
    private val symbol: String,
    private val function: (x: Long, y: Long) -> Long
) {

    ADD("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    fun operate(num1: Long, num2: Long): Long {
        return function.invoke(num1, num2)
    }

    companion object {
        fun of(symbol: String): Operator {
            return values()
                .find { it.symbol == symbol } ?: throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }
    }
}
