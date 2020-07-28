package racingcar

object InputValidator {
    private const val MIN_TRY_COUNT = 1

    fun isValidTryCount(value: String?): Boolean = value?.toIntOrNull().let {
        it != null && it >= MIN_TRY_COUNT
    }
}
