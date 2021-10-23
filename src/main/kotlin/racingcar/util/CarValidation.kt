package racingcar.util

import racingcar.extension.StringExtension.isIntType
import racingcar.ui.InputView

object CarValidation {
    private const val ZERO = 0
    private const val MIN_CONDITION = 4
    const val MAX_CONDITION = 9

    fun isMatchCondition(num: Int) = num >= MIN_CONDITION

    fun isPositiveNumber(number: Int) = number > ZERO

    fun getCarCountToInt(carCount: String): Int {
        return if (carCount.isIntType() && isPositiveNumber(carCount.toInt())) {
            carCount.toInt()
        } else {
            InputView.retryGetCarCount()
        }
    }

    fun getAttemptCountToInt(attemptCount: String): Int {
        return if (attemptCount.isIntType() && isPositiveNumber(attemptCount.toInt())) {
            attemptCount.toInt()
        } else {
            InputView.retryGetAttemptCount()
        }
    }
}
