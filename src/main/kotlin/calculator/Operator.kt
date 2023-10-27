package calculator

enum class Operator(val value: String) {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    companion object {
        fun findSymbol(value: String): Operator = values().find { it.value == value }
            ?: throw IllegalArgumentException()
    }
}
