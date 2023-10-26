package calculator

enum class Operator(
    val operator: String,
    val operation: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),
    ;

    companion object {
        fun of(operator: String): Operator {
            return values().find { it.operator == operator } ?: throw IllegalArgumentException("연산자가 아닙니다.")
        }
    }

    fun operate(a: Int, b: Int): Int {
        return operation(a, b)
    }
}
