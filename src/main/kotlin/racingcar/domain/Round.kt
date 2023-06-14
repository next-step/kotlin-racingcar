package racingcar.domain

import racingcar.view.Messages

@JvmInline
value class Round(
    val attemptCount: Int
) {
    init {
        validateAttemptCount(attemptCount)
    }

    private fun validateAttemptCount(count: Int) {
        require(count > MINIMUM_ATTEMPT_COUNT) {
            Messages.MESSAGE_CONDITION_ATTEMPT_COUNT
        }
    }

    companion object {
        const val MINIMUM_ATTEMPT_COUNT = 1
    }
}
