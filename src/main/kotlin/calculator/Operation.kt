package calculator

enum class Operation(val value: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"), ;

    companion object {
        fun fromString(element: String): Operation {
            values().forEach { if (it.value == element) return it }
            throw IllegalArgumentException(ErrorMessage.UNSUPPORTED_OPERATOR_MSG.message)
        }
    }
}
