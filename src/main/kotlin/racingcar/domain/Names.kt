package racingcar.domain

class Names(
    val names: List<Name>,
) {
    init {
        if (names.size < START_CONDITION) {
            throw IllegalArgumentException(VALIDATION_MESSAGE)
        }
    }

    companion object {
        private const val START_CONDITION = 2
        private const val VALIDATION_MESSAGE = "자동차 경주는 두 대 이상부터 시작할 수 있습니다."
    }
}
