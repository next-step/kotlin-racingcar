package calculator

enum class Operator(private val operator: String) {
    PLUS("+"), MINUS("-"), TIMES("*"), DIV("/");

    companion object {
        fun from(operator: String): Operator? = values().find { it.operator == operator }
    }
}
