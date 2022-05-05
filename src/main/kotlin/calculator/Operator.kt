package calculator

enum class Operator(val operator: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    companion object {
        fun stringOf(operatorString: String): Operator =
            values().find { it.operator == operatorString }!!
    }
}
