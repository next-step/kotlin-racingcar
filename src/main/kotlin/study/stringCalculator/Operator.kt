package study.stringCalculator

enum class Operator(val symbol: String, val work: (Int, Int) -> Int) {
    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun reverseMap(string: String): Operator? = Operator.values().find { it.symbol == string }
    }
}