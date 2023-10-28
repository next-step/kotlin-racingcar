package calculator

enum class ErrorMessage(val message: String) {
    INVALID_INPUT_ERROR_MSG("입력값이 유효하지 않다"),
    NULL_OR_BLANK_ERROR_MSG("입력값이 null이거나 빈 공백이다"),
    UNSUPPORTED_OPERATOR_MSG("지원하지 않는 연산자입니다."),
}
