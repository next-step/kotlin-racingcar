package racingcar.domain

object ExceptionType {
    const val INPUT_MUST_NOT_NULL = "입력이 비어서는 안됩니다."
    const val TRY_INPUT_MUST_UNSIGNED_INT = "시도할 횟수입력은 양의 정수 여야만 합니다."
    const val CAR_NAME_LIMIT_LENGTH_OVER = "허용 가능한 자동차 이름 길이를 초과 했습니다."
}
