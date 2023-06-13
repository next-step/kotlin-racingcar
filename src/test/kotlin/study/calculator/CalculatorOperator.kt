package study.calculator

enum class CalculatorOperator(
    val symbol: String,
    val calculate: (Int, Int) -> Int
) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    TIMES("*", { x, y -> x * y }),
    DIVIDEDBY("/", { x, y -> x / y });

    companion object {
        fun operator(symbol: String): CalculatorOperator {
            return CalculatorOperator.values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("question allows only integer or +, -, * and /.")
        }
    }
}
