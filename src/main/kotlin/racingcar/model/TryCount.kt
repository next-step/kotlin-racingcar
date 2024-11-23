package racingcar.model

class TryCount {
    fun getTryCount(tryCount: Int): Int {
        require(tryCount >= TRY_COUNT_MIN) { TRY_COUNT_RANGE_ERROR_MESSAGE }
        return tryCount
    }

    companion object {
        private const val TRY_COUNT_RANGE_ERROR_MESSAGE = "시도 횟수는 1이상의 수만 입력 가능 합니다."
        private const val TRY_COUNT_MIN = 1
    }
}
