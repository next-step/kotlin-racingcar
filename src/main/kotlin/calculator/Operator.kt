package calculator

enum class Operator(private val operator: String, private val operation: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    fun calculate(x: Int, y: Int): Int {
        return operation(x, y)
    }

    companion object {
        fun from(operator: String): Operator {
            return values().find {
                it.operator == operator
            } ?: throw IllegalArgumentException("알 수 없는 Operator 발생 : $operator")
        }
    }
}
