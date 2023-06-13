package racingcar.domain

import racingcar.view.Messages

data class Round(
    var attemptCount: Int
) {
    init {
        validateAttemptCount(attemptCount)
    }

    private fun validateAttemptCount(count: Int) {
        if (count < MINIMUM_ATTEMPT_COUNT) {
            throw IllegalArgumentException(Messages.MESSAGE_CONDITION_ATTEMPT_COUNT)
        }
    }

    companion object {
        const val MINIMUM_ATTEMPT_COUNT = 1
    }
}
