package step2

enum class Operator(val operator: String, val operation: (Int, Int) -> Int) {
    PLUS("+", operation = { x, y -> x + y }),
    MINUS("-", operation = { x, y -> x - y }),
    MULTIPLY("*", operation = { x, y -> x * y }),
    DIVIDE("/", operation = { x, y -> x / y });

    companion object {
        fun from(operator: String): Operator? {
            return values().find { it.operator == operator }
        }
    }

    fun calculate(x: Int, y: Int): Int {
        return operation(x, y)
    }
}
