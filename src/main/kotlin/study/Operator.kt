package study

enum class Operator(val symbol: String) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    fun calculateSinglePair(a: Int, b: Int): Int =
        when (this) {
            ADD -> a + b
            SUBTRACT -> a - b
            MULTIPLY -> a * b
            DIVIDE -> a / b
        }

    companion object {
        fun reverseMap(string: String): Operator? = Operator.values().find { it.symbol == string }
    }
}