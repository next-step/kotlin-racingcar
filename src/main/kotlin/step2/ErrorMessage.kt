package step2

enum class ErrorMessage(val message: String) {
    NULL_OR_BLANK("Input value is Null or Blank"),
    INVALID_OPERATOR("Not Supported Operator"),
    NOT_ENOUGH_OPERAND("Not Enough Operand"),
    INVALID_NUMBER_FORMAT("Invalid Number Format");

    override fun toString(): String = message
}
