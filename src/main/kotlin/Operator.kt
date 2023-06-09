enum class Operator(val operator: String) {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/");

    companion object {
        fun findOperator(operator: String): Operator? = values().firstOrNull { it.operator == operator }
    }
}
