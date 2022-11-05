package step2

enum class Operator(val sign: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    fun calculate(left: Int, right: Int): Int {
        return when (this) {
            PLUS -> left + right
            MINUS -> left - right
            MULTIPLY -> left * right
            DIVIDE -> left / right
        }
    }

    companion object {
        fun from(sign: String): Operator {
            return if (sign == "+") PLUS
            else if (sign == "-") MINUS
            else if (sign == "*") MULTIPLY
            else DIVIDE
        }
    }
}
