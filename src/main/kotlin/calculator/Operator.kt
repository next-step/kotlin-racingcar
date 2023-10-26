package calculator

enum class Operator(private val op: String) {
    PLUS("+"), MINUS("-"), TIMES("*"), DIV("/");

    companion object {
        fun from(operator: String): Operator? = values().find { it.op == operator }
    }
}
