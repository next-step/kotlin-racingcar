package calculator.application

enum class Operator(val operator: String) {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    companion object {
        fun isOperator(token: String): Boolean {
            return token in setOf(
                ADD.operator,
                SUB.operator,
                MUL.operator,
                DIV.operator,
            )
        }
    }
}
