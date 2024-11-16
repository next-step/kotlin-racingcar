package racingcar.model

import racingcar.model.exception.TryCountException

private const val TRY_COUNT_MIN = 1

class TryCount {
    fun getTryCount(tryCount: Int): Int {
        if (tryCount < TRY_COUNT_MIN) {
            throw TryCountException()
        }
        return tryCount
    }
}
