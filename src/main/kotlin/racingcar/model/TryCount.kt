package racingcar.model

import racingcar.model.exception.TryCountException

class TryCount {
    fun getTryCount(userTryCount: Int): Int {
        val tryCount = saveTryCount(userTryCount)
        TryCountException.checkTryCountRange(tryCount)
        return tryCount
    }

    private fun saveTryCount(userTryCount: Int): Int {
        TryCountException.checkTryCountRange(userTryCount)
        return userTryCount
    }
}
