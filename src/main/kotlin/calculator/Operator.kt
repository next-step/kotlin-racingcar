package calculator

enum class Operator(private val operand: String, private val operation: (Int, Int) -> Int) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    MULTIPLY("*", { first, second -> first * second }),
    DIVIDE("/", { first, second -> first / second });

    fun calculate(first: Int, second: Int) = operation(first, second)

    companion object {
        fun of(operand: String): Operator = values().firstOrNull { operand == it.operand } ?: throw IllegalArgumentException("Invalid operand: $operand")
    }
}
