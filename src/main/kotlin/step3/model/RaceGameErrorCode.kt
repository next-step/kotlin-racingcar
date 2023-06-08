package step3.model

enum class RaceGameErrorCode(val message: (String) -> String) {
    INVALID_CAR_COUNT(
        message = { input -> "자동차 대수 최소조건에 충족하지 않습니다. (최소조건 입력값)) : $input" },
    ),
    NOT_REMAINING_ROUND(
        message = { input -> "라운드 수가 남아있지 않습니다. 남은 라운드 수 : $input" },
    ),
    INVALID_ROUND_INPUT(
        message = { input -> "라운드는 숫자형이어야 합니다. 입력값 : $input" },
    ),
    INVALID_CAR_NAME_INPUT(
        message = { input -> "자동차 이름은 정해진 글자 수를 초과할 수 없습니다. 제한값 : $input" },
    ),
}
