package calculator

enum class Operator(val symbol: String, val action: (Int, Int) -> Int) {
    ADD("+", { num1, num2 -> num1 + num2 }),
    SUBTRACT("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 }),
    ;

    companion object {
        fun contains(other: String): Boolean {
            return Operator.entries.any { it.symbol == other }
        }
    }
}
