package calculator.exception

enum class ErrorMessages(val message: String) {
    INVALID_INPUT_EXCEPTION("유효하지 않은 입력입니다."),
    INVALID_OPERATOR_EXCEPTION("유효하지 않은 연산자입니다."),
    INVALID_NUMBER_INPUT_EXCEPTION("유효하지 않은 숫자 입력입니다."),
    NOT_SUPPORTED_OPERATOR("지원하지 않는 연산자입니다.")
    ;
}
