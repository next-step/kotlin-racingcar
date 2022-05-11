package calculator

enum class Operator(val string: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    companion object {
        const val ERROR_MESSAGE_BY_OPERARTOR_STRING = "올바르지 않은 연산자 입니다."

        fun stringOf(stringOperator: String): Operator =
            values().find { it.string == stringOperator } ?: throw IllegalArgumentException(ERROR_MESSAGE_BY_OPERARTOR_STRING)
    }
}
