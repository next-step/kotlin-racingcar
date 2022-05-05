package calculator

enum class Operator(
    private val symbol: String,
    private val function: (Int, Int) -> Int
) {
    ADDITION("+", { first, second -> first + second }),
    SUBTRACTION("-", { first, second -> first - second }),
    MULTIPLICATION("*", { first, second -> first * second }),
    DIVISION("/", { first, second ->
        if (second == 0) {
            throw IllegalArgumentException("0으로는 나눌 수 없습니다.")
        }
        first / second
    });

    fun calculate(first: Int, second: Int): Int {
        return function.invoke(first, second)
    }

    companion object {
        fun of(symbol: String): Operator {
            return Operator.values()
                .find { it.symbol == symbol }
                ?: throw IllegalArgumentException("{$symbol}에 일치하는 연산자가 존재하지 않습니다.")
        }
    }
}
