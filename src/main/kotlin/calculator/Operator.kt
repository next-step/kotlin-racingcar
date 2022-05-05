package calculator

enum class Operator(val string: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    companion object {
        fun stringOf(stringOperator: String): Operator =
            values().find { it.string == stringOperator }!!
    }
}
