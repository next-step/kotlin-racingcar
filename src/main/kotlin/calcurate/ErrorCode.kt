package calcurate

enum class ErrorCode(val msg: String) {
    INVALID_EXPRESSION("입력 값이 null 혹은 빈 공백 문자입니다."),
    INVALID_CALC_SYMBOL("유효하지 않은 calc symbol 입니다."),
    INVALID_DIVIDE_VALUE("나누는 값이 0 입니다.")
}
