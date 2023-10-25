package calculator

enum class ErrorMessage(val message: String) {
    MINIMUM_SIZE_REQUIREMENT_MSG("문자열 사이즈가 3보다 커야 한다"),
    ODD_SIZE_REQUIREMENT_MSG("문자열 사이즈가 기수 이여야 한다"),
    NULL_OR_BLANK_ERROR_MSG("입력값이 null이거나 빈 공백이다"),
    UNSUPPORTED_OPERATOR_MSG("지원하지 않는 연산자입니다."),
}
