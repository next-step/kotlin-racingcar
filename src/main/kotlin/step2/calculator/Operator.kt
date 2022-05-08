package step2.calculator

enum class Operator(
    private val symbol: String,
    private val function: (Double, Double) -> Double
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDED("/", { a, b -> a / b })
    ;

    fun operate(numberPair: NumberPair): Double {
        return function(numberPair.first, numberPair.second)
    }

    companion object {
        fun findOperator(symbol: String): Operator {
            val matched = values().firstOrNull { it.symbol == symbol }
            if (matched != null) {
                return matched
            }
            throw IllegalArgumentException("해당 연산자를 찾을 수 없습니다. `$symbol`")
        }
    }
}
