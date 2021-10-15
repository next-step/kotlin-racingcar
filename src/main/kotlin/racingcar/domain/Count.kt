package racingcar.domain

class Count(
    val value: Int,
) {
    companion object {
        private const val START_CONDITION = 1
        private const val VALIDATION_MESSAGE = "자동차 경주 횟수는 1회 이상부터 시작할 수 있습니다."
    }

    init {
        if (value < START_CONDITION) {
            throw IllegalArgumentException(VALIDATION_MESSAGE)
        }
    }
}
