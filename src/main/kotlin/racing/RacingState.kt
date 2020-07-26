package racing

class RacingState(var number: String? = "", var attempt: String? = "") {

    private val NON_NUMERIC_REGEX = Regex("[^0-9]")

    companion object {
        const val MINIMUM_CAR_COUNT = 1
        const val DATA_IS_BLANK = "값이 비어있습니다"
        const val IS_POSSIBLE_NUMERIC = "숫자만 입력 가능합니다"
        const val NUMBER_REQUIRE_OVER_ONE = "자동차 개수는 1이상의 값을 요구합니다"
    }

    fun validate(racingState: RacingState) {
        val number = racingState.number
        val attempt = racingState.attempt
        if (number.isNullOrBlank() || attempt.isNullOrBlank()) {
            throw IllegalArgumentException(DATA_IS_BLANK)
        }
        if (NON_NUMERIC_REGEX.matches(number) || NON_NUMERIC_REGEX.matches(attempt)) {
            throw IllegalArgumentException(IS_POSSIBLE_NUMERIC)
        }
        if (number.toInt() < MINIMUM_CAR_COUNT) {
            throw IllegalArgumentException(NUMBER_REQUIRE_OVER_ONE)
        }
    }
}
