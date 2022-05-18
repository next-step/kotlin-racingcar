package racing.model

import racing.exception.TimesException

class Times(val value: Int) {
    init {
        if (value <= 0) throw TimesException(INVALID_TIMES)
    }

    companion object {
        private const val INVALID_TIMES = "시도 횟수는 0보다 커야 합니다."
    }
}
