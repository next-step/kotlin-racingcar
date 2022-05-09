package calculator

enum class Operator(val operand: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    MULTIPLY("*", { first, second -> first * second }),
    DIVIDE("/", { first, second -> first / second });

    fun calculate(first: Int, second: Int) = operation(first, second)

    companion object {
        fun get(operand: String): Operator = values().firstOrNull { operand == it.operand } ?: throw IllegalArgumentException("Invalid operand: $operand")
    }
}
