package racingcar.domain

class Number(
    val value: Int,
) {
    companion object {
        private const val START_CONDITION = 2
        private const val VALIDATION_MESSAGE = "자동차 경주는 두대 이상부터 시작할 수 있습니다."
    }

    init {
        if (value < START_CONDITION) {
            throw IllegalArgumentException(VALIDATION_MESSAGE)
        }
    }
}
