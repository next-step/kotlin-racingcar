package calculator.util

object Calculator

enum class Operator(
    private val operator: String,
    private val calculator: (Int, Int) -> Int
) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });

    companion object {
        fun calculate(num1: Int, operator: String, num2: Int): Int {
            return values().firstOrNull { it.operator == operator }?.calculator?.invoke(num1, num2)
                ?: throw IllegalArgumentException("invalid operator")
        }
    }
}
