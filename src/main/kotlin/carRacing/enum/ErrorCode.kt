package carRacing.enum

enum class ErrorCode(val code: Int, val message: String) {
    OVER_INPUT_TRY(1000, "입력 횟수를 초과하였습니다."),
    INPUT_EMPTY(1001, "입력값이 없습니다."),
    INPUT_IS_NOT_NUMBER(1002, "숫자를 입력해주세요."),
    WRONG_INPUT(1003, "잘못된 입력입니다."),
    OVER_INPUT_TRY_LEFT(1004, "${WRONG_INPUT.message} [0]번 더 입력할 수 있습니다."),
    MISMATCHED_VARIABLE_COUNT(2000, "변수의 개수가 일치하지 않습니다.")
}
