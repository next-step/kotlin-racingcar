package calculator
enum class Operators(private val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun findBySymbol(symbol: String): Boolean {
            val result = Operators.values().find { it.symbol == symbol }
            return result != null
        }
    }
}
