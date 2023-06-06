package step2.model

enum class ErrorCode(val message: (String) -> String) {
    INVALID_OPERATOR_CODE(
        message = { input -> "정의되지 않은 연산자 커맨드입니다. 입력 커맨드값 : $input" },
    ),
    INVALID_CALCULATOR_INPUT(
        message = { input -> "연산 입력값은 연산자보다 숫자의 수가 하나 더 많아야 합니다. (숫자 연산자 개수) : $input" },
    ),
    INVALID_NUMBER_INPUT(
        message = { input -> "연산 입력값 중 홀수 순서는 숫자가 입력되어야 합니다. 입력값 : $input" },
    ),
}
