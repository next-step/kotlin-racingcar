package racing.util

class CarUtil {
    companion object {
        val NON_NUMERIC_REGEX = Regex("[^0-9]")
        val DELIMETER = ","

        const val MINIMUM_CAR_COUNT = 1
        const val DATA_IS_BLANK = "값이 비어있습니다"
        const val IS_POSSIBLE_NUMERIC = "숫자만 입력 가능합니다"
        const val DATA_FORMMAT_IS_BAD = "데이터 입력 포멧이 이상합니다"
        const val NUMBER_REQUIRE_OVER_ONE = "자동차 개수는 1이상의 값을 요구합니다"

        fun validate(names: String?, attempt: String?) {
            if (names.isNullOrBlank() || attempt.isNullOrBlank()) {
                throw IllegalArgumentException(DATA_IS_BLANK)
            }
            var carNames = splitNames(names)
            if (carNames.isNullOrEmpty()) {
                throw IllegalArgumentException(DATA_FORMMAT_IS_BAD)
            }

            if (NON_NUMERIC_REGEX.matches(names) || NON_NUMERIC_REGEX.matches(attempt)) {
                throw IllegalArgumentException(IS_POSSIBLE_NUMERIC)
            }
            if (names.toInt() < MINIMUM_CAR_COUNT) {
                throw IllegalArgumentException(NUMBER_REQUIRE_OVER_ONE)
            }
        }

        fun splitNames(names: String) = names.split(DELIMETER).filter { name -> name.isNotBlank() }
    }
}
