package racing.util

object CarUtil {
    val NON_NUMERIC_REGEX = Regex("[^0-9]")
    val DELIMETER = ","

    const val IS_POSSIBLE_NUMERIC = "숫자만 입력 가능합니다"
    const val DATA_FORMMAT_IS_BAD = "데이터 입력 포멧이 이상합니다"
    const val EXCEED_FIVE_CHARACTERS = "자동차 이름은 5자를 초과 할 수 없습니다"

    fun validate(names: String, attempt: String) {
        var carNames = splitNames(names)
        if (carNames.isNullOrEmpty()) {
            throw IllegalArgumentException(DATA_FORMMAT_IS_BAD)
        }

        if (NON_NUMERIC_REGEX.matches(attempt)) {
            throw IllegalArgumentException(IS_POSSIBLE_NUMERIC)
        }

        carNames.forEach { name ->
            if (name.length > 5) {
                throw IllegalArgumentException(EXCEED_FIVE_CHARACTERS)
            }
        }
    }

    fun splitNames(names: String) =
        names
            .split(DELIMETER)
            .filter { name -> name.isNotBlank() }
            .map { name -> name.trim() }
}
