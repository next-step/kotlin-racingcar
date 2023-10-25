package calculator

enum class Operator(private val operator: String, private val operation: (Int, Int) -> Int) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    DIVIDE("/", { left, right -> left / right });

    fun calculate(left: Int, right: Int): Int {
        return operation(left, right)
    }

    companion object {
        fun from(operator: String): Operator {
            values().forEach {
                if (it.operator == operator) {
                    return it
                }
            }
            throw IllegalArgumentException("알 수 없는 Operator 발생 : $operator")
        }
    }
}
