package calculator

enum class Operator(val value: String) {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun from(op: String) = values().find { it.value == op }
    }
}
