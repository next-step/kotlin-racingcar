package racingcar

object InputValidator {
    private const val MIN_CAR_COUNT = 1
    private const val MIN_TRY_COUNT = 1

    fun isValidCarCount(value: Int) = value >= MIN_CAR_COUNT

    fun isValidTryCount(value: Int) = value >= MIN_TRY_COUNT
}
