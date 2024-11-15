package racingcar.model.exception

import racingcar.common.ErrorMessage

class TryCountException(errorMessage: String?) : IllegalArgumentException(errorMessage) {
    companion object {
        private const val TRY_COUNT_MIN = 1

        fun checkTryCountRange(tryCount: Int) {
            if (tryCount < TRY_COUNT_MIN) {
                throw TryCountException(ErrorMessage.TRY_COUNT_RANGE_ERROR_MESSAGE.errorMessage)
            }
        }
    }
}
