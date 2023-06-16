package racingcar.domain

@JvmInline
value class Round(
    val attemptCount: Int
) {
    init {
        validateAttemptCount(attemptCount)
    }

    private fun validateAttemptCount(count: Int) {
        require(count > MINIMUM_ATTEMPT_COUNT) {
            MESSAGE_CONDITION_ATTEMPT_COUNT
        }
    }

    companion object {
        const val MESSAGE_CONDITION_ATTEMPT_COUNT = "시도 횟수는 1회 이상이여야 합니다."
        const val MINIMUM_ATTEMPT_COUNT = 1
    }
}
