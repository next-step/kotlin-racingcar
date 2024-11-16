package racingcar.model.exception

private const val TRY_COUNT_RANGE_ERROR_MESSAGE = "시도 횟수는 1이상의 수만 입력 가능 합니다."

class TryCountException(errorMessage: String = TRY_COUNT_RANGE_ERROR_MESSAGE) : IllegalArgumentException(errorMessage)
