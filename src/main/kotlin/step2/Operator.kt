package step2

enum class Operator(val sign: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun from(sign: String): Operator {
            return if (sign == "+") PLUS
            else if (sign == "-") MINUS
            else if (sign == "*") MULTIPLY
            else DIVIDE
        }
    }
}
