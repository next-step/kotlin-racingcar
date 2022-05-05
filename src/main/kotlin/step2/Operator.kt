package step2

enum class Operator(
    val symbol: Char,
    private val function: (a: Int, b: Int) -> Int
) {
    ADDITION('+', { a, b -> a + b }),
    SUBTRACTION('-', { a, b -> a - b }),
    MULTIPLICATION('*', { a, b -> a * b }),
    DIVISION('/', { a, b -> a / b });

    fun operate(a: Int, b: Int): Int {
        return function.invoke(a, b)
    }

    companion object {
        fun of(symbol: Char) = values().first { it.symbol == symbol }
    }
}
