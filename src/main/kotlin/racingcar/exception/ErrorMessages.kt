package racingcar.exception

enum class ErrorMessages(val message: String) {
    INVALID_NUMBER_INPUT_EXCEPTION("유효하지 않은 숫자 입력입니다."),
    INVALID_NUMBER_RANGE_EXCEPTION("입력 값은 양수여야 합니다."),
    ;
}
