package racingcar.model

import racingcar.model.exception.TryCountException

private const val TRY_COUNT_MIN = 1

class TryCount {
    fun getTryCount(userTryCount: Int): Int {
        val tryCount = saveTryCount(userTryCount)
        if (tryCount < TRY_COUNT_MIN) {
            throw TryCountException()
        }
        return tryCount
    }

    private fun saveTryCount(userTryCount: Int): Int {
        if (userTryCount < TRY_COUNT_MIN) {
            throw TryCountException()
        }
        return userTryCount
    }
}
