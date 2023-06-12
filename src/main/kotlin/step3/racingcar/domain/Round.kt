package step3.racingcar.domain

import step3.racingcar.view.Messages

data class Round(
    var attemptCount: Int
) {
    init {
        validateAttemptCount(attemptCount)
    }

    private fun validateAttemptCount(count: Int) {
        if (count < 1) {
            throw IllegalArgumentException(Messages.MESSAGE_CONDITION_ATTEMPT_COUNT)
        }
    }
}