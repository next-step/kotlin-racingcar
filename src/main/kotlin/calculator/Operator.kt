package calculator

enum class Operator(val operator: String, val operation: (Long, Long) -> Long) {
    PLUS("+", { left: Long, right: Long -> left + right }),
    MINUS("-", { left: Long, right: Long -> left - right }),
    MULTIPLY("*", { left: Long, right: Long -> left * right }),
    DIVIDE("/", { left: Long, right: Long -> left / right });
}
