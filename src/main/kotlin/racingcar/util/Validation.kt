package racingcar.util

import racingcar.constant.Constant
import racingcar.constant.Message
import racingcar.extension.StringExtension.isIntType

object Validation {
    private const val MIN_CONDITION = 4
    private const val MAX_CAR_NAME_COUNT = 5
    const val MAX_CONDITION = 9
    const val DELIMITER = ","

    fun isMatchStartCondition(num: Int) = num >= MIN_CONDITION

    fun isPositiveNumber(number: Int) = number > Constant.ZERO

    fun checkNameCountCondition(carNames: String) {
        carNames.split(DELIMITER).forEach {
            require(it.length <= MAX_CAR_NAME_COUNT) { IllegalArgumentException(Message.ILLEGAL_NAME_COUNT) }
        }
    }

    fun checkTryCountCondition(attemptCount: String) {
        require(attemptCount.isIntType()) { IllegalArgumentException(Message.ILLEGAL_INT_TYPE) }
        require(isPositiveNumber(attemptCount.toInt())) { IllegalArgumentException(Message.ILLEGAL_POSITIVE_NUMBER) }
    }
}
